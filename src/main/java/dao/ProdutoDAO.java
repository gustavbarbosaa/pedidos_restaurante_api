package dao;

import domain.Produto;
import persistence.JPAUtil;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO {

    private JPAUtil jpaUtil;

    public ProdutoDAO (){
        jpaUtil = new JPAUtil();
    }


    public void save(Produto produto){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(produto);
        jpaUtil.getEntityManager().getTransaction().commit();
        jpaUtil.getEntityManager().close();
    }

    public Produto produtoById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        return jpaUtil.getEntityManager()
                .find(Produto.class, id);
    }

    public List<Produto> getAllProdutos(){

        //utilizando jpql
        jpaUtil.getEntityManager().getTransaction().begin();
       // String jpql = "select p from Produto p";
        var query = jpaUtil.getEntityManager()
                .createNamedQuery("produto.getAll");
        return query.getResultList();
    }

    public List<Produto> getAllProdutosByPreco(BigDecimal valor){

        jpaUtil.getEntityManager().getTransaction().begin();
        // String jpql = "select p from Produto p";
        var query = jpaUtil.getEntityManager()
                .createNamedQuery("produto.byPrice");
        query.setParameter("preco", valor);
        return query.getResultList();
    }
}
