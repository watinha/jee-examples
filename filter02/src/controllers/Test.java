package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ResourceBundle;

import java.io.IOException;

public class Test extends HttpServlet {
    public void doGet (HttpServletRequest req,
                       HttpServletResponse res) throws IOException {
        ResourceBundle bundle = (ResourceBundle) req.getAttribute("bundle");
        res.setContentType("text/html");
        res.getWriter().println("<h1>" + bundle.getString("SUPIMPA") +
                                "</h1>");
    }
}
