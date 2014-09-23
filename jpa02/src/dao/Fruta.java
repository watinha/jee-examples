package dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Version;

@Entity
public class Fruta {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    private int count;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void inc () {
        this.count++;
    }

    public Fruta () {}
    public Fruta (String nome) {
        this.setNome(nome);
        this.count = 0;
    }
}
