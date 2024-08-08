package sp.electronics.core.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ImpuestoDTO {
    private Integer id;
    private String nombre;
    private Double valor;
    private Boolean estado;
}
