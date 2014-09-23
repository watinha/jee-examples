package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CidadesModel {

    private static List <CidadesModel> cidades;

    private CidadesModel (String nome) {
        this.nome = nome;
    }
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public static void loadAll (String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(
                                 new FileReader(filePath));
        CidadesModel.cidades = new ArrayList <CidadesModel> ();
        while (reader.ready())
            CidadesModel.cidades.add(new CidadesModel(reader.readLine()));
        Collections.sort(CidadesModel.cidades, new Comparator <CidadesModel>() {
            public int compare (CidadesModel c1, CidadesModel c2) {
                return c1.getNome().compareTo(c2.getNome());
            }
        });
    }

    public static List <CidadesModel> find () {
        return CidadesModel.cidades.subList(0, 15);
    }

    public static List <CidadesModel> find (String busca) {
        List <CidadesModel> list = new ArrayList <CidadesModel> ();
        for (CidadesModel cidade : CidadesModel.cidades) {
            if (cidade.getNome().toUpperCase().startsWith(busca.toUpperCase()))
                list.add(cidade);
        }
        return list;
    }


}
