package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import models.Usuario;

public class FirstWeb extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
        this.doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
		ArrayList <Usuario> list = new ArrayList <Usuario> ();
		for (int i = 0; i < 10; i++) {
			Usuario usuario = new Usuario();
			usuario.setId(1);
			usuario.setNome("Usuario " + i);
			list.add(usuario);
		}

        String novo = request.getParameter("something");
        if (novo != null) {
            Usuario usuario = new Usuario();
            usuario.setId(99);
            usuario.setNome(novo);
            list.add(usuario);
        }

        String url = request.getServletPath();

        request.setAttribute("deslogarUrl", "/?deslogar=1");
		request.setAttribute("list", list);
		request.setAttribute("url", url);
		request.getRequestDispatcher("/web-inf/views/common/main.jsp")
			   .forward(request, response);
    }
}
