package br.edu.utfpr.mvc01.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.mvc01.model.pojo.Cidade;

public class CidadeModel {
    private static EntityManagerFactory factory = null;

    public EntityManagerFactory getFactory () {
        if (CidadeModel.factory == null)
            CidadeModel.factory = Persistence.createEntityManagerFactory("jpa01");
        return CidadeModel.factory;
    }

    public List <Cidade> busca (String nome) {
        EntityManager em = this.getFactory().createEntityManager();
        return em.createQuery("SELECT c FROM Cidade c WHERE c.nome like :nome")
                 .setParameter("nome", nome + "%")
                 .getResultList();
    }
}
