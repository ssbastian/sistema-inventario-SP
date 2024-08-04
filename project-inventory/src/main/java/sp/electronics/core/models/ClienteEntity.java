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
@PrimaryKeyJoinColumn(name = "IdCliente")
@Table(name= "Cliente")
public class ClienteEntity extends ContactoEntity{
    
    //atributos adicionales de contacto
    private Date cliFechaRegistro;
    private Double cliLimiteCredito;

   

    public ClienteEntity(Integer conId, Integer conTipoDocumento, Integer conNumDocumento,
                    String conNombre, String conApellido, Date conFechaCrea,
                    String conDireccion, Integer conTel, String conEmail, Date cliFechaRegistro, Double cliLimiteCredito) 
    {
        super(conId, conTipoDocumento, conNumDocumento, conNombre, conApellido,
              conFechaCrea, conDireccion, conTel, conEmail); // Llama al constructor de Persona
        this.cliFechaRegistro = cliFechaRegistro; // Inicializa el nuevo campo de Empleado
        this.cliLimiteCredito = cliLimiteCredito;
    }
}
