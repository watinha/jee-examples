package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

public class Users extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("deslogar") != null) {
            request.getSession().invalidate();
        }

        if (request.getSession().getAttribute("login") != null) {
            response.sendRedirect((request.getHeader("Location") == null ?
                                        "/abobrinha" : request.getHeader("Location")));
            return ;
        }
        String url = "/";
        request.setAttribute("url", url);
        request.getRequestDispatcher("web-inf/views/users/login.jsp")
               .forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("login").equals("Willian") &&
            request.getParameter("passwd").equals("123")) {
            HttpSession session = request.getSession();
            session.setAttribute("login", "Willian");
        }
        response.sendRedirect("/abobrinha");
    }

}
