package edu.utfpr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.utfpr.model.FrutaModel;
import edu.utfpr.model.pojo.Fruta;

@WebServlet(urlPatterns={"/fruta"})
public class FrutasController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet (HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        FrutaModel model = new FrutaModel();
        List <Fruta> lista = model.listar(req.getParameter("busca"));
        res.setContentType("application/json");
        res.getWriter().print((new Gson()).toJson(lista));
    }

    public void doPost (HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        FrutaModel model = new FrutaModel();
        if (req.getParameter("method").equals("adicionar"))
            model.inserir(req.getParameter("nome"));
        if (req.getParameter("method").equals("deletar"))
            model.deletar(Long.parseLong(req.getParameter("id")));
        if (req.getParameter("method").equals("editar"))
            model.deletar(Long.parseLong(req.getParameter("id")));
    }
}
