package sp.electronics.core.services.sevices;

import java.util.List;

import sp.electronics.core.services.DTO.ImpuestoDTO;

public interface IImpuestoService {
    public List<ImpuestoDTO> finAll();

    public ImpuestoDTO finById(Integer id);

    public ImpuestoDTO save (ImpuestoDTO ImpuestoDTO);

    public ImpuestoDTO update (Integer id, ImpuestoDTO impuesto);

    public boolean delete (Integer id);
}
