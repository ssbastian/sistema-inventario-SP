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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sp.electronics.core.services.DTO.ProductoDTO;
import sp.electronics.core.services.sevices.IProductoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class ProductoRestControllers {
    
    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<ProductoDTO> index() {
        return productoService.finAll();
    }

    /*@GetMapping("/productos/{id}")
    public ProductoDTO show (@PathVariable Integer id) {
        ProductoDTO objProductoDTO = null;
        objProductoDTO = this.productoService.finById(id);
        return objProductoDTO;
    }*/
    @GetMapping("/productos/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        ProductoDTO objProductoDTO = productoService.finById(id);
        if (objProductoDTO == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "El producto con ID: " + id + " no existe en la base de datos.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(objProductoDTO, HttpStatus.OK);
    }

    /*@PostMapping("/productos")
    public ProductoDTO create (@RequestBody ProductoDTO producto) {
        ProductoDTO objProductoDTO = null;
        objProductoDTO = this.productoService.save(producto);
        return objProductoDTO;
    }*/

    @PostMapping("/productos")
    public ResponseEntity<?> create(@Validated @RequestBody ProductoDTO producto, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        ProductoDTO objProductoDTO;

        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();
            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("El campo '" + error.getField() + "' " + error.getDefaultMessage());
            }
            response.put("errors", listaErrores);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            objProductoDTO = this.productoService.save(producto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción en la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(objProductoDTO, HttpStatus.CREATED);
    }


    /*@PutMapping("/productos/{id}")
    public ProductoDTO update (@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        ProductoDTO objProductoDTO = null;
        objProductoDTO = this.productoService.update(id, objProductoDTO);
        return objProductoDTO;
    }*/

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> update(@Validated @RequestBody ProductoDTO producto, BindingResult result, @PathVariable Integer id) {
        ProductoDTO productoActual = productoService.finById(id);
        ProductoDTO productoUpdated;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();
            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("El campo '" + error.getField() + "' " + error.getDefaultMessage());
            }
            response.put("errors", listaErrores);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (productoActual == null) {
            response.put("mensaje", "Error: No se pudo editar, el producto ID: " + id + " no existe en la base de datos!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {
            productoActual.setProId(producto.getProId());
            productoActual.setProCodigo(producto.getProCodigo());
            productoActual.setProImagenes(producto.getProImagenes());
            productoActual.setProModelo(producto.getProModelo());
            productoActual.setProDescripcion(producto.getProDescripcion());
            productoActual.setProMarca(producto.getProMarca());
            productoActual.setProCantidad(producto.getProCantidad());
            productoActual.setProPrecioUnitario(producto.getProPrecioUnitario());
            productoActual.setProEstado(producto.getProEstado());
            productoActual.setCatId(producto.getCatId());

            productoUpdated = productoService.save(productoActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el producto en la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto ha sido actualizado con éxito!");
        response.put("producto", productoUpdated);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /*@DeleteMapping("/productos/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Boolean bandera = false;
        ProductoDTO objProductoDTO = productoService.finById(id);
        if(objProductoDTO != null) {
            bandera = productoService.delete(id);
        }
        return bandera;
    }*/

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        try {
            ProductoDTO objProductoDTO = productoService.finById(id);
            if (objProductoDTO == null) {
                response.put("mensaje", "Error: No se pudo eliminar, el producto ID: " + id + " no existe en la base de datos!");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            productoService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el producto de la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto ha sido eliminado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
