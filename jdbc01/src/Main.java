import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main (String args[])
                       throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
            "jdbc:mysql://abobrinha.com/supimpa", "root", "");
        PreparedStatement p = c.prepareStatement("SELECT * FROM frutas;");
        ResultSet r = p.executeQuery();
        while(r.next())
            System.out.println(r.getString("nome"));
        c.close();
    }

    public static void inserir ()
                       throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
            "jdbc:mysql://abobrinha.com/supimpa", "root", "");
        PreparedStatement p = c.prepareStatement("INSERT INTO frutas (nome) VALUES (?)");
        p.setString(1, "Amora");
        p.executeUpdate();
        c.close();
    }

    public static void update ()
                       throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
            "jdbc:mysql://abobrinha.com/supimpa", "root", "");
        PreparedStatement p = c.prepareStatement("UPDATE frutas SET nome = ? WHERE nome = ?");
        p.setString(1, "AAAAOOOlegalUPDATE");
        p.setString(2, "Amora");
        p.executeUpdate();
        c.close();
    }

    public static void delete ()
                       throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
            "jdbc:mysql://abobrinha.com/supimpa", "root", "");
        PreparedStatement p = c.prepareStatement("DELETE FROM frutas WHERE nome = ?");
        p.setString(1, "AAAAOOOlegalUPDATE");
        p.executeUpdate();
        c.close();
    }
}
