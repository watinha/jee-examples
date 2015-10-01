package br.edu.utfpr.mvc01.model.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cidade {
    @Id @GeneratedValue
    private long id;
    private String nome;

    public long getId(){ return this.id; }
    public void setId(long id){ this.id = id; }
    public String getNome(){ return this.nome; }
    public void setNome(String nome){ this.nome = nome; }
}
