package models;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList <String> getLista() {
        ArrayList <String> lista = new ArrayList <String> ();
        lista.add("abobrinhac");
        lista.add("abacate");
        lista.add("pepino");
        lista.add("abacaxi");
        lista.add("melao");
        lista.add("uva");
        return lista;
    }
}
