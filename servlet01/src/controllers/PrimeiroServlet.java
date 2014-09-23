package controllers;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

public class PrimeiroServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        PrintWriter writer = res.getWriter();
        writer.println("Ola");
        writer.println(" Mundo supimpa");
    }
}
