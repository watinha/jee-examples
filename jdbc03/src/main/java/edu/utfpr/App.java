package edu.utfpr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://abobrinha.com:3306/jdbc01", "root", "");
        PreparedStatement ps = c.prepareStatement("SELECT * FROM Cidades");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("nome"));
        }
        c.close();
    }
}
