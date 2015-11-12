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

@WebServlet(urlPatterns={"/cidade"})
public class CidadeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet (HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = res.getWriter();
        String busca = req.getParameter("nome");
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://abobrinha.com/jdbc_01", "root", "");
            PreparedStatement ps = c.prepareStatement(
                    "SELECT * FROM cidades WHERE nome like ?");
            ps.setString(1, busca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                writer.println("<li>" + rs.getString("nome") + "</li>");
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
