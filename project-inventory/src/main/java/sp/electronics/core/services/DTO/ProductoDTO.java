package sp.electronics.core.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductoDTO {
    private Integer proCodigo;
    private byte[] proImagen; 
   
    private String proModelo;
    private String proDescripcion;
    private Integer proCantidad;
    private Double proPrecioUnitario;
    private Integer proEstado;

    private ImpuestoDTO obj;
}
