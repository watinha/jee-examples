import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import dao.Fruta;

public class Main {
    public static void main (String args[]) {
        EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("supimpa");
        EntityManager em = factory.createEntityManager();
        List <Fruta> list = em.createQuery("SELECT t from Fruta as t")
                              .getResultList();
        System.out.println();
        for (Fruta fruta : list)
            System.out.println(fruta.getNome());
        factory.close();
    }

    public static void generateTables () {
        EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("supimpa");
        EntityManager em = factory.createEntityManager();
        factory.close();
    }

    public static void insert (EntityManagerFactory factory) {
        EntityManager em = factory.createEntityManager();
        Fruta fruta = new Fruta("abacaxi");
        em.getTransaction().begin();
        em.persist(fruta);
        em.getTransaction().commit();
        em.close();
    }

    public static void update (EntityManagerFactory factory) {
        EntityManager em = factory.createEntityManager();
        Fruta fruta = (Fruta) em.createQuery("SELECT t FROM Fruta t WHERE t.nome=:nome")
                                .setParameter("nome", "abacaxi")
                                .getSingleResult();
        fruta.setNome("amora");
        em.getTransaction().begin();
        em.persist(fruta);
        em.getTransaction().commit();
        em.close();
    }

    public static void delete (EntityManagerFactory factory) {
        EntityManager em = factory.createEntityManager();
        Fruta fruta = (Fruta) em.createQuery("SELECT t FROM Fruta t")
                                .getSingleResult();
        em.getTransaction().begin();
        em.remove(fruta);
        em.getTransaction().commit();
        em.close();
    }
}
