package controllers;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import models.CidadesModel;

public class CidadesController extends HttpServlet {

    public void init (ServletConfig config) throws ServletException {
        try {
            CidadesModel.loadAll(config.getServletContext()
                                       .getRealPath(config.getInitParameter(
                                                        "cidades_file")));
        } catch (IOException e) {
            throw new ServletException(e.getMessage());
        }
    }

    public void doGet (HttpServletRequest req,
                       HttpServletResponse res) throws IOException, ServletException {
        List <CidadesModel> cidades = req.getParameter("busca") == null ?
            CidadesModel.find() : CidadesModel.find(req.getParameter("busca"));
        req.setAttribute("cidades", cidades);
        req.setAttribute("title", "Cidades Busca");
        req.setAttribute("busca", req.getParameter("busca"));
        req.getRequestDispatcher("/WEB-INF/views/cidades/list.jsp")
           .forward(req, res);
    }
}
