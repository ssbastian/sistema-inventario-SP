package sp.electronics.core.models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Impuestos")
public class ImpuestoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer impId;
    private String impNombre;
    private Double impValor;
    private Boolean impEstado;

    
/*     @ManyToMany(fetch = FetchType.LAZY, mappedBy = "objImpuesto")
    private Iterable<ProductoEntity> productos;
 */
}
