package sp.electronics.core.services.sevices;

import java.util.List;

import sp.electronics.core.services.DTO.ProductoDTO;

public interface IProductoService {
    
    public List<ProductoDTO> finAll();

    public ProductoDTO finById(Integer id);

    public ProductoDTO save (ProductoDTO productoDTO);

    public ProductoDTO update (Integer id, ProductoDTO producto);

    public boolean delete (Integer id);
    
}
