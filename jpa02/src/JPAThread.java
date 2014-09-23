import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.lang.Double;
import java.lang.Thread;
import java.lang.Math;

import dao.Fruta;

public class JPAThread extends Thread {

    private EntityManagerFactory factory;
    private int id;

    public JPAThread (int id, EntityManagerFactory factory) {
        this.factory = factory;
        this.id = id;
    }

    public static synchronized void doTomeStuff (EntityManager em) {
        Fruta fruta = (Fruta) em.createQuery("SELECT t FROM Fruta t WHERE t.id = :id")
                                .setParameter("id", 1)
                                .getSingleResult();

        fruta.inc();
        em.getTransaction().begin();
        em.persist(fruta);
        em.getTransaction().commit();
        em.close();
    }

    public void run () {
        try {
            int sleepTime = (new Double(Math.floor(Math.random() * 2000))).intValue();
            this.sleep(sleepTime);
            long time = System.currentTimeMillis();
            EntityManager em = this.factory.createEntityManager();
            Fruta fruta = new Fruta("thread " + this.id);
            em.getTransaction().begin();
            em.persist(fruta);
            em.getTransaction().commit();

            JPAThread.doTomeStuff(em);

            System.out.println(this.id + " : " + (System.currentTimeMillis() - time));
        } catch (InterruptedException e) {};
    }
}
