package sp.electronics.core.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Contacto" )
public class ProductoEntity {
    
    private Integer proCodigo;
    private Integer proImagen; //TOO
    private String proModelo;
    private String proDescripcion;
    private Integer proCantidad;
    private Double proPrecioUnitario;
    private Integer proEstado;
}
