package sp.electronics.core.services.sevices;

import java.util.List;

import sp.electronics.core.services.DTO.CategoriaDTO;

public interface ICategoriaService {
    public List<CategoriaDTO> finAll();

    public CategoriaDTO finById(Integer id);

    public CategoriaDTO save (CategoriaDTO CategoriaDTO);

    public CategoriaDTO update (Integer id, CategoriaDTO categoria);

    public boolean delete (Integer id);
}
