package sp.electronics.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/productos/{id}")
    public ProductoDTO show (@PathVariable Integer id) {
        ProductoDTO objProductoDTO = null;
        objProductoDTO = this.productoService.finById(id);
        return objProductoDTO;
    }

    @PostMapping("/productos/")
    public ProductoDTO create (@RequestBody ProductoDTO producto) {
        ProductoDTO objProductoDTO = null;
        objProductoDTO = this.productoService.save(producto);
        return objProductoDTO;
    }

    @PutMapping("/productos/{id}")
    public ProductoDTO update (@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        ProductoDTO objProductoDTO = null;
        objProductoDTO = this.productoService.update(id, objProductoDTO);
        return objProductoDTO;
    }

    @DeleteMapping("/productos/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Boolean bandera = false;
        ProductoDTO objProductoDTO = productoService.finById(id);
        if(objProductoDTO != null) {
            bandera = productoService.delete(id);
        }
        return bandera;
    }

}
