package sp.electronics.core.services.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
//LAS VALIDACIONES DEBEN IR AQUI
public class ProductoDTO {
    private Integer proId;
    private String proCodigo;
    private List<String> proImagenes;
    private String proModelo;
    private String proDescripcion;
    private String proMarca;
    private Integer proCantidad;
    private Double proPrecioUnitario;
    private Integer proEstado;
    private Integer catId; // Solo guardamos el ID de la categoría en lugar de todo el objeto


    /* private ImpuestoDTO obj; */
}
