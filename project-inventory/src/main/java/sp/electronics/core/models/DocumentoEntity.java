package sp.electronics.core.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "Documento")
public class DocumentoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer docId;
    private Date docFechaEmision;
    private Integer docEstado;
    private String docDescripcion;
    private Integer FormaPago;
    private Double docTotal;
    private Double docImpuesto;
    private Date docFechaVencimiento;

}
