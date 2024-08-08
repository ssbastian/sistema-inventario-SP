package sp.electronics.core.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "Producto" )
public class ProductoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proCodigo;
   
    @Lob // Indica que este campo se almacena como un tipo de datos BLOB en la base de datos
    private byte[] proImagen; 
    private String proModelo;
    private String proDescripcion;
    private Integer proCantidad;
    private Double proPrecioUnitario;
    private Integer proEstado;
}
