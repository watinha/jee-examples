package br.edu.utfpr.mvc01.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.mvc01.model.CidadeModel;
import br.edu.utfpr.mvc01.model.pojo.Cidade;

@WebServlet(urlPatterns={"/cidade"})
public class CidadeController extends HttpServlet {

    public void doGet (HttpServletRequest req, HttpServletResponse res)
                throws IOException, ServletException {
        String busca = req.getParameter("busca") == null ?
                            "" : req.getParameter("busca");
        CidadeModel model = new CidadeModel();
        List <Cidade> lista = model.busca(busca);
        req.setAttribute("lista", lista);
        req.getRequestDispatcher("/WEB-INF/view/cidade.jsp")
           .forward(req, res);
    }

}
