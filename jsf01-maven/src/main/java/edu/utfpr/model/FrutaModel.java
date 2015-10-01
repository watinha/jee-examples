package edu.utfpr.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.utfpr.model.pojo.Fruta;

public class FrutaModel {
    private static EntityManagerFactory factory = null;

    public void inserir (String novaFruta, String novaCor) {
        Fruta f = new Fruta();
        EntityManager em = FrutaModel.getEM();
        f.setNome(novaFruta);
        f.setCor(novaCor);
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
    }

    @SuppressWarnings("unchecked")
    public List <Fruta> getFrutas () {
        EntityManager em = FrutaModel.getEM();
        List <Fruta> lista = (List <Fruta>) em.createQuery("SELECT f FROM Fruta f").getResultList();
        em.close();
        return lista;
    }

    private static EntityManager getEM () {
        if (FrutaModel.factory == null)
            FrutaModel.factory = Persistence.createEntityManagerFactory("persistence");
        return FrutaModel.factory.createEntityManager();
    }

}
