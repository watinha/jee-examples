package edu.utfpr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/fruta"})
public class Fruta extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter writer = res.getWriter();
        res.setContentType("text/html; encoding=utf-8");
        writer.println("<!DOCTYPE HTML>");
        writer.println("<html>");
        writer.println("    <head>");
        writer.println("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
        writer.println("        <title>Fruta</title>");
        writer.println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" charset=\"utf-8\"/>");
        writer.println("    </head>");
        writer.println("    <body>");
        writer.println("        <h1>Frutas</h1>");

        writer.println("<fieldset>");
        writer.println("<legend>Formulário</legend>");
        writer.println("<form action=\"fruta\" method=\"POST\" accept-charset=\"utf-8\">");
        writer.println("<label for=\"nome\">Nome:</label>");
        writer.println("<input type=\"text\" name=\"nome\" value=\"\" id=\"nome\"/>");
        writer.println("<input type=\"submit\" value=\"adicionar\"></p>");
        writer.println("</form>");
        writer.println("</fieldset>");

        writer.println("<ul>");
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://abobrinha.com/jdbc_test", "root", "");
            PreparedStatement ps = c.prepareStatement(
                    "SELECT * FROM Frutas");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                writer.println("    <li>" + rs.getString("nome"));

                writer.println("<form action=\"fruta\" method=\"POST\" accept-charset=\"utf-8\">");
                writer.println("    <input type=\"hidden\" name=\"id\" value=\"" + rs.getInt("id") + "\"/>");
                writer.println("    <input type=\"submit\" name=\"metodo\" value=\"deletar\"/>");
                writer.println("</form>");

                writer.println("    </li>");
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        writer.println("</ul>");

        writer.println("    </body>");
        writer.println("</html>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if (req.getParameter("metodo") != null && req.getParameter("metodo").equals("deletar")) {
            Connection c;
            try {
                c = DriverManager.getConnection("jdbc:mysql://abobrinha.com/jdbc_test", "root", "");
                PreparedStatement ps = c.prepareStatement(
                        "DELETE FROM Frutas WHERE id = ?");
                ps.setInt(1, Integer.parseInt(req.getParameter("id")));
                ps.executeUpdate();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://abobrinha.com/jdbc_test", "root", "");
                PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO Frutas(nome) VALUES (?)");
                ps.setString(1, req.getParameter("nome"));
                ps.executeUpdate();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        res.sendRedirect("fruta");
    }

}
