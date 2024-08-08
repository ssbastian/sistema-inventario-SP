package sp.electronics.core.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sp.electronics.core.services.DTO.ImpuestoDTO;
import sp.electronics.core.services.DTO.ProductoDTO;
import sp.electronics.core.services.sevices.IImpuestoService;

@RestController
@RequestMapping("/api")
public class ImpuestoRestControllers {
	/* 
     @Autowired
    private IImpuestoService impuestoService;

    @GetMapping("/impuestos")
    public List<ImpuestoDTO> index() {
        return impuestoService.finAll();
    }
		*/
    
    @Autowired
	private IImpuestoService impuestoService;

	@GetMapping("/impuestos")
	public List<ImpuestoDTO> index() {
		System.out.println("sdsds");
		return impuestoService.finAll();
	}

	
	@PostMapping("/impuestos")	
	public ResponseEntity<?>  create(@Validated @RequestBody ImpuestoDTO impuesto, BindingResult result) {
		
		Map<String, Object> response = new HashMap<>();
		ImpuestoDTO objImpuesto;
				
		if(result.hasErrors())
		{

			List<String> listaErrores= new ArrayList<>();

			for (FieldError error : result.getFieldErrors()) {
				listaErrores.add("El campo '" + error.getField() +"‘ "+ error.getDefaultMessage());
			}

			response.put("errors", listaErrores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		
		try {
			objImpuesto=this.impuestoService.save(impuesto);
		} 
		catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción en la base de datos");
			response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ImpuestoDTO>(objImpuesto, HttpStatus.OK);

	}

	
	@GetMapping("/impuestos/{id}")
    public ImpuestoDTO show (@PathVariable Integer id) {
        ImpuestoDTO objImpuestoDTO = null;
        objImpuestoDTO = this.impuestoService.finById(id);
        return objImpuestoDTO;
    }

	
	@PutMapping("/impuestos/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody ImpuestoDTO impuesto, BindingResult result, @PathVariable Integer id) {

		ImpuestoDTO impuestoActual = impuestoService.finById(id);

		ImpuestoDTO impuestoUpdated = null;

		Map<String, Object> response = new HashMap<>();

		
		if(result.hasErrors())
		{

			List<String> listaErrores= new ArrayList<>();

			for (FieldError error : result.getFieldErrors()) {
				listaErrores.add("El campo '" + error.getField() +"‘ "+ error.getDefaultMessage());
			}

			response.put("errors", listaErrores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}
		
						
		if (impuestoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el impuesto ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			impuestoActual.setId(impuesto.getId());
			impuestoActual.setNombre(impuesto.getNombre());
			impuestoActual.setValor(impuesto.getValor());
			impuestoActual.setEstado(impuesto.getEstado());

			impuestoUpdated = impuestoService.save(impuestoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el impuesto en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El impuesto ha sido actualizado con éxito!");
		response.put("cliente", impuestoUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	/* 
	@DeleteMapping("/impuestos/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		    impuestoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el impuesto de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El impuesto eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
		*/
	@DeleteMapping("/impuestos/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Boolean bandera = false;
        ImpuestoDTO objImpuestoDTO = impuestoService.finById(id);
        if(objImpuestoDTO != null) {
            bandera = impuestoService.delete(id);
        }
        return bandera;
    }
    
}
