import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

import dao.Fruta;

public class Main {
    public static void main (String args[]) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("supimpa");
        EntityManager em = factory.createEntityManager();
        Fruta fruta = new Fruta("Primeira");
        em.getTransaction().begin();
        em.persist(fruta);
        em.getTransaction().commit();
        em.close();
        for (int i = 0; i < 89; i++) {
            Thread t = new JPAThread(i + 1, factory);
            t.start();
        }
    }
}
