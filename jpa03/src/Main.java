import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import dao.Usuario;
import dao.Carro;

public class Main {
    public static void main (String args[]) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("supimpa");
        EntityManager em = factory.createEntityManager();

        List <Usuario> list = em.createQuery("SELECT u FROM Usuario u")
                                .getResultList();
        for (Usuario u : list) {
            System.out.println(u.getNome() + " <-> " + u.getCarro().getNome());
        }

        factory.close();
    }

    public static void insert (EntityManager em) {
        for (int i = 1; i < 11; i++) {
            Usuario u = new Usuario("Nome " + i);
            u.setCarro(new Carro("Carro " + i));
            em.getTransaction().begin();
            em.persist(u);
            em.persist(u.getCarro());
            em.getTransaction().commit();
        }
    }

}
