package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class FrutaFactory {

    private Connection c;

    public FrutaFactory (Connection c) {
        this.c = c;
    }

    public List<Fruta> getAll () throws SQLException {
        PreparedStatement p = this.c.prepareStatement("SELECT * FROM frutas;");
        ResultSet r = p.executeQuery();
        ArrayList <Fruta>list = new ArrayList <Fruta> ();
        while(r.next())
            list.add(new Fruta(r.getString("nome")));
        return list;
    }
}
