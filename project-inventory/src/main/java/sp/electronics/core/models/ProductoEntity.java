package sp.electronics.core.models;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proId;

    @Column(unique = true, nullable = true)
    private String proCodigo;

    /* @OrderBy("proCodigo ASC")  // Orden automático por proCodigo */
    private List<String> proImagenes; // Guarda solo URLs

    private String proModelo;
    private String proDescripcion;
    private String proMarca;
    private Integer proCantidad;
    private Double proPrecioUnitario;
    private Integer proEstado;

    @ManyToOne
    @JoinColumn(name = "catId", nullable = false)
    private CategoriaEntity objCategoria;
}
