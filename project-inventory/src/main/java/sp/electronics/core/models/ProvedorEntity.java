package sp.electronics.core.models;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

@Entity
@PrimaryKeyJoinColumn(name = "IdProvedor")
@Table(name="Provedor")


public class ProvedorEntity extends ContactoEntity{
    
    //atributos adicionales a contacto
    private String proRazonSocial;

    public ProvedorEntity(Integer conId, Integer conTipoDocumento, Integer conNumDocumento,
                    String conNombre, String conApellido, Date conFechaCrea,
                    String conDireccion, Integer conTel, String conEmail, String proRazonSocial) 
    {
        super(conId, conTipoDocumento, conNumDocumento, conNombre, conApellido,
              conFechaCrea, conDireccion, conTel, conEmail); // Llama al constructor de Persona
        this.proRazonSocial = proRazonSocial; // Inicializa el nuevo campo de Empleado
    }
}
