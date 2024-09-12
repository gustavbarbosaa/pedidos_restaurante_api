package domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "produto.getAll", query = "select p from Produto p"),
        @NamedQuery(name = "produto.byPrice", query = "select p from Produto p where p.preco > :preco"),
        @NamedQuery(name = "produto.byName", query = "select p from Produto p where p.nome = :nome"),
        @NamedQuery(name = "produto.byNameLike", query = "select p from Produto p where p.nome like :nome")
})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    @Column(name = "descricao_produto")
    private String descricao;
    private String categoria;
}
