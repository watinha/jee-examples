package servlets01;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimeiraServlet extends HttpServlet {

    public void doGet (HttpServletRequest req,
                       HttpServletResponse res) throws IOException {
        PrintWriter writer = res.getWriter();
        writer.println("<!DOCTYPE HTML>");
        writer.println("<html>");
        writer.println("    <head>");
        writer.println("        <title>First Servlet</title>");
        writer.println("        <script type=\"text/javascript\"");
        writer.println("                src=\"jquery.js\"></script>");
        writer.println("    </head>");
        writer.println("    <body>");
        writer.println("      <h1>Abobrinha 1</h1>");
        writer.println("      <form action=\"/supimpa\" method=\"GET\">");
        writer.println("      <input type=\"text\" name=\"q\" value=\"\"/>");
        writer.println("      <input type=\"submit\" value=\"Continue &rarr;\">");
        writer.println("      <div style=\"padding: 10px; background-color: yellow\">");
        writer.println(req.getParameter("q"));
        writer.println("      </div>");
        writer.println("        </form>");
        writer.println("    </body>");
        writer.println("</html>");
    }

}
