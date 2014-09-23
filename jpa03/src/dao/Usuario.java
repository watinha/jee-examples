package dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Version;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    private String nome;

    @OneToOne
    private Carro carro;

    public Carro getCarro () { return this.carro; }
    public void setCarro (Carro carro) { this.carro = carro; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Usuario () {}
    public Usuario (String nome) { this.setNome(nome); }
}
