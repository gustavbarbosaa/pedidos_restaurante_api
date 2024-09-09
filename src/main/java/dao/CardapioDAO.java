package dao;

import domain.Cardapio;
import lombok.RequiredArgsConstructor;
import persistence.JPAUtil;


@RequiredArgsConstructor
public class CardapioDAO {

    private JPAUtil jpaUtil;

    public void save(Cardapio cardapio) {
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(cardapio);
        jpaUtil.getEntityManager().getTransaction().commit();
        jpaUtil.getEntityManager().close();
    }

    public Cardapio getCardapio(Long id) {
        jpaUtil.getEntityManager().getTransaction().begin();
        return jpaUtil.getEntityManager().find(Cardapio.class, id);
    }
}
