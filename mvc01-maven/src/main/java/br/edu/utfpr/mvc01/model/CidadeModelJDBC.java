package br.edu.utfpr.mvc01.model;

import java.util.List;

import br.edu.utfpr.mvc01.model.pojo.Cidade;

public class CidadeModelJDBC {
    public List <Cidade> busca (String nome) {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://abobrinha.com/jpa01", "root", "");
        PreparedStatment ps = c.prepareStatment(
                "SELECT * FROM Cidades WHERE nome like ?");
        ps.setString(1, nome + "%");
        ResultSet rs = ps.executeQuery();
        List <Cidade> lista = new ArrayList <Cidade> ();
        while (rs.next()) {
            Cidade c = new Cidade();
            c.setNome(rs.getString("nome"));
            lista.add(c);
        }
        return lista;
    }
}
