package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_estoque")
@NamedQueries({
        @NamedQuery(name = "estoque.getAll", query = "select e from Estoque e"),
})
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> produtos;

    @NotEmpty(message = "Campo quantidade é obrigatório!")
    private Integer quantidade;
}
