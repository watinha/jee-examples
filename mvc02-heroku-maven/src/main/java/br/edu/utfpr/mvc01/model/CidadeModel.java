package br.edu.utfpr.mvc01.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.mvc01.model.pojo.Cidade;

public class CidadeModel {
    private static EntityManagerFactory factory = null;

    public EntityManagerFactory getFactory () {
        if (CidadeModel.factory == null) {
            try {
                if (System.getenv("DATABASE_URL") == null) {
                    CidadeModel.factory = Persistence.createEntityManagerFactory("jpa01");
                } else {
                    URI dbUri = new URI(System.getenv("DATABASE_URL"));
                    String username = dbUri.getUserInfo().split(":")[0];
                    String password = dbUri.getUserInfo().split(":")[1];
                    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() +
                                  ':' + dbUri.getPort() + dbUri.getPath();
                    Map <String, String> config_override = new HashMap <String, String> ();
                    config_override.put("javax.persistence.jdbc.url", dbUrl);
                    config_override.put("javax.persistence.jdbc.user", username);
                    config_override.put("javax.persistence.jdbc.password", password);
                    CidadeModel.factory = Persistence.createEntityManagerFactory(
                            "jpa01", config_override);
                }
            } catch (URISyntaxException ex) {
                CidadeModel.factory = Persistence.createEntityManagerFactory("jpa01");
            }
        }
        return CidadeModel.factory;
    }

    public List <Cidade> busca (String nome) {
        EntityManager em = this.getFactory().createEntityManager();
        List <Cidade> lista =  em.createQuery("SELECT c FROM Cidade c WHERE c.nome like :nome")
                                 .setParameter("nome", nome + "%")
                                 .getResultList();
        em.close();
        return lista;
    }

    public void inserir (String nome) {
        EntityManager em = this.getFactory().createEntityManager();
        Cidade nova = new Cidade();
        nova.setNome(nome);
        em.getTransaction().begin();
        em.persist(nova);
        em.getTransaction().commit();
        em.close();
    }
}
