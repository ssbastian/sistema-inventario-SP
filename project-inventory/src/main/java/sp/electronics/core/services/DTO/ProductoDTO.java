package sp.electronics.core.services.DTO;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;



@Getter @Setter @NoArgsConstructor @AllArgsConstructor
//LAS VALIDACIONES DEBEN IR AQUI
public class ProductoDTO {
    @NotNull(message = "El ID no puede ser nulo")
    private Integer proId;

    @NotBlank(message = "El código no puede estar vacío")
    @Size(min = 1, max = 10, message = "El código debe tener entre 1 y 10 caracteres")
    private String proCodigo;
    private List<String> proImagenes;
    @Size(min = 1, max = 200, message = "El modelo debe tener entre 1 y 200 caracteres")
    private String proModelo;    
    private String proDescripcion;
    @Size(min = 1, max = 20, message = "La marca debe tener entre 1 y 20 caracteres")
    private String proMarca;
    @PositiveOrZero(message = "La cantidad no puede ser negativa")
    @NotNull(message = "La cantidad no puede ser nula")
    private Integer proCantidad;
    @PositiveOrZero(message = "El precio unitario no puede ser negativo")
    @NotNull(message = "El precio unitario no puede ser nulo")
    private Double proPrecioUnitario;
    @NotNull(message = "El estado no puede ser nulo")
    private Integer proEstado;
    @NotNull(message = "La categoría no puede ser nula")
    private Integer catId; // Solo guardamos el ID de la categoría en lugar de todo el objeto

    /* private ImpuestoDTO obj; */
}
