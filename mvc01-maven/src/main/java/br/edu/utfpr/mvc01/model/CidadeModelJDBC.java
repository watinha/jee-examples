package br.edu.utfpr.mvc01.model;

import java.util.List;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.utfpr.mvc01.model.pojo.Cidade;

public class CidadeModelJDBC {
    public List <Cidade> busca (String nome) {
        List <Cidade> lista = new ArrayList <Cidade> ();
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://abobrinha.com/jpa01", "root", "");
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM Cidades WHERE nome like ?");
            ps.setString(1, nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade c = new Cidade();
                c.setNome(rs.getString("nome"));
                lista.add(c);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco de dados...");
            e.printStackTrace();
        }
        return lista;
    }
}
