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

    public void doGet (HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        PrintWriter writer = res.getWriter();
        res.setContentType("text/html; charset=utf-8");
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://abobrinha.com/jdbc_01", "root", "");
            PreparedStatement ps  = c.prepareStatement(
                    "SELECT * FROM frutas");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                writer.println(rs.getString("nome") + ",");
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            res.setStatus(500);
        }
    }

    public void doPost (HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        String nome = req.getParameter("nome");
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://abobrinha.com/jdbc_01", "root", "");
            PreparedStatement ps  = c.prepareStatement(
                    "INSERT INTO frutas (nome) VALUES (?)");
            ps.setString(1, nome);
            ps.executeUpdate();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        }
    }
}
