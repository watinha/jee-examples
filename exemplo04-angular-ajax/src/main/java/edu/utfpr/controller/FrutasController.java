package edu.utfpr.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.utfpr.model.FrutaModel;

@WebServlet(urlPatterns={"/fruta"})
public class FrutasController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost (HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        FrutaModel model = new FrutaModel();
        model.inserir(req.getParameter("nome"));
    }
}
