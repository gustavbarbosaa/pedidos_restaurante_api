package dao;

import domain.Pessoa;
import lombok.RequiredArgsConstructor;
import persistence.JPAUtil;

import java.util.List;

@RequiredArgsConstructor
public class PessoaDAO {

    private JPAUtil jpaUtil;


    public void save(Pessoa pessoa) {
       jpaUtil.getEntityManager().getTransaction().begin();
       jpaUtil.getEntityManager().persist(pessoa);
       jpaUtil.getEntityManager().getTransaction().commit();
       jpaUtil.getEntityManager().close();
    }

    public Pessoa pessoabyId(Long id) {
        jpaUtil.getEntityManager().getTransaction().begin();
        return jpaUtil.getEntityManager().find(Pessoa.class, id);
    }

    public List<Pessoa> getPessoas() {
        jpaUtil.getEntityManager().getTransaction().begin();
        var query = jpaUtil.getEntityManager().createNamedQuery("pessoa.getAll");

        return query.getResultList();
    }

    


}
