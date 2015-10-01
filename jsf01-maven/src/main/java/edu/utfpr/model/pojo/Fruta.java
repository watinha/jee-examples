package edu.utfpr.model.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fruta {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String cor;
    public void setNome(String nome){ this.nome = nome; }
    public String getNome(){ return this.nome; }
    public void setCor(String cor){ this.cor = cor; }
    public String getCor(){ return this.cor; }
    public void setId(Long id){ this.id = id; }
    public Long getId(){ return this.id; }
}
