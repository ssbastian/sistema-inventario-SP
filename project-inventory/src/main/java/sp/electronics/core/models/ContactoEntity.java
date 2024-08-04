package sp.electronics.core.models;

import java.sql.Date;

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
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Contacto")
public class ContactoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer conId;
    private Integer conTipoDocumento;
    private Integer conNumDocumento;
    private String conNombre;
    private String conApellido;
    private Date conFechaCrea;
    private String conDireccion;
    private Integer conTel;
    private String conEmail;

}
