package edu.utfpr.model;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

import java.util.List;

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

    public List <Fruta> listar (String busca) {
        EntityManager em = this.getFactory().createEntityManager();

        @SuppressWarnings("unchecked")
        List<Fruta> lista = em.createQuery("SELECT f FROM Fruta f WHERE f.nome like :busca")
            .setParameter("busca", busca + "%")
            .getResultList();

        em.close();
        return lista;
    }

    public void deletar (long id) {
        EntityManager em = this.getFactory().createEntityManager();
        Fruta f = em.find(Fruta.class, new Long(id));
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        em.close();
    }

    public EntityManagerFactory getFactory () {
        if (FrutaModel.factory == null)
            FrutaModel.factory = Persistence.createEntityManagerFactory("jpa01");
        return FrutaModel.factory;
    }

}
