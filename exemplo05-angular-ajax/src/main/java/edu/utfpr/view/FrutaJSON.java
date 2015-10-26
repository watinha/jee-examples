package edu.utfpr.view;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;

import edu.utfpr.model.pojo.Fruta;

public class FrutaJSON {
    public String convert (List <Fruta> lista) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Fruta f : lista) {
            builder.add(Json.createObjectBuilder()
                            .add("nome", f.getNome())
                            .add("id", f.getId()));
        }
        return builder.build().toString();
    }
}
