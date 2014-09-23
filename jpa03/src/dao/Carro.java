package dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Version;

@Entity
public class Carro {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    private String nome;

    @OneToOne(mappedBy="carro")
    private Usuario dono;

    public Usuario getDono () { return this.dono; }
    public void setDono (Usuario dono) { this.dono = dono; }

    public String getNome () { return nome; }
    public void setNome (String nome) { this.nome = nome; }

    public Carro () {}
    public Carro (String nome) { this.setNome(nome); }
}

