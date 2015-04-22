package servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;

@WebServlet(urlPatterns={"/"})
public class FirstTryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Inject private UsuarioDao dao;

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("cdi_hello", this.dao.getMessage());
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, res);
    }
}
