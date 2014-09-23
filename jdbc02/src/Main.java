import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import dao.Fruta;
import dao.FrutaFactory;

public class Main {
    public static void main (String args[])
                       throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://abobrinha.com/supimpa", "root", "");
        FrutaFactory factory = new FrutaFactory(c);
        List <Fruta> list = factory.getAll();
        for (Fruta fruta : list)
            System.out.println(fruta.getNome());
        c.close();
    }
}
