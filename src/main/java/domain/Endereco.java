package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cidade;
    private String rua;
    private String bairro;
    private String numero;
}
