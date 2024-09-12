package dao;

import domain.Estoque;
import domain.Pessoa;
import domain.Produto;
import lombok.RequiredArgsConstructor;
import persistence.JPAUtil;

@RequiredArgsConstructor
public class PessoaDAO {

    private final JPAUtil jpaUtil;

    public void save(Pessoa pessoa){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(pessoa);
        jpaUtil.getEntityManager().getTransaction().commit();
        jpaUtil.getEntityManager().close();
    }

    public String realizarPedido(Long produtoId, int quantidade) {
        jpaUtil.getEntityManager().getTransaction().begin();
        Estoque estoque = jpaUtil.getEntityManager().find(Estoque.class, produtoId);

        if (estoque.getQuantidade().equals(0)) {
            jpaUtil.getEntityManager().getTransaction().rollback();
            return "Produto indiponível";
        } else if (estoque.getQuantidade() < quantidade) {
            jpaUtil.getEntityManager().getTransaction().rollback();
            return "Só temos essa quantidade de itens: " + estoque.getQuantidade();
        }

        estoque.setQuantidade(estoque.getQuantidade() - quantidade);
        jpaUtil.getEntityManager().merge(estoque);
        jpaUtil.getEntityManager().getTransaction().commit();

        return "Pedido realizado com sucesso!";
    }
}
