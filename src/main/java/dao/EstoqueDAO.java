package dao;

import domain.Estoque;
import domain.Produto;
import persistence.JPAUtil;

import java.util.List;

public class EstoqueDAO {

    private JPAUtil jpaUtil;

    public EstoqueDAO() { this.jpaUtil = new JPAUtil(); }

    public void save(Estoque estoque) {
        this.jpaUtil.getEntityManager().getTransaction().begin();
        this.jpaUtil.getEntityManager().persist(estoque);
        this.jpaUtil.getEntityManager().getTransaction().commit();
        this.jpaUtil.getEntityManager().close();
    }

    public Estoque estoque(long id) {
        jpaUtil.getEntityManager().getTransaction().begin();
        return jpaUtil.getEntityManager().find(Estoque.class, id);
    }
}
