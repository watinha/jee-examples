package edu.utfpr.model;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

import edu.utfpr.model.pojo.Fruta;

public class FrutaModel {

    private static EntityManagerFactory factory = null;

    public void inserir (String nome) {
        Fruta nova = new Fruta();
        nova.setNome(nome);
        EntityManager em = this.getFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(nova);
        em.getTransaction().commit();
        em.close();
    }

    public EntityManagerFactory getFactory () {
        if (FrutaModel.factory == null)
            FrutaModel.factory = Persistence.createEntityManagerFactory("jpa01");
        return FrutaModel.factory;
    }

}
