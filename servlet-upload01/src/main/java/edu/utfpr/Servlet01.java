package edu.utfpr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns="/01")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
                 maxFileSize=1024*1024*10,
                 maxRequestSize=1024*1024*50)
public class Servlet01 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private int id = 0;

    public void doGet (HttpServletRequest req,
                       HttpServletResponse res) throws IOException {
        PrintWriter writer = res.getWriter();

        writer.println("<!DOCTYPE HTML>");
        writer.println("<html>");
        writer.println("    <head>");
        writer.println("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
        writer.println("        <title>Servlet01</title>");
        writer.println("    </head>");
        writer.println("    <body>");
        writer.println("        <h1>Exemplos upload com servlet</h1>");
        writer.println("        <form action=\"01\" method=\"POST\"");
        writer.println("                          accept-charset=\"utf-8\"");
        writer.println("                          enctype=\"multipart/form-data\">");
        writer.println("            <input type=\"file\" name=\"arquivo\" value=\"\" />");
        writer.println("            <input type=\"submit\" name=\"enviar\" value=\"submit\" />");
        writer.println("        </form>");
        writer.println("<ul>");
        for (int i = 0; i < this.id; i++) {
            writer.println("    <li><img src=\"uploads/" + i + ".png\" height=\"100\"></img></li>");
        }
        writer.println("</ul>");
        writer.println("    </body>");
        writer.println("</html>");
    }

    public void doPost (HttpServletRequest req,
                        HttpServletResponse res) throws IOException, ServletException {
        Part part = req.getPart("arquivo");
        String images_path = req.getServletContext().getRealPath("/uploads");
        InputStream in = part.getInputStream();
        if (part.getContentType().equals("image/png")) {
            Files.copy(in, Paths.get(images_path + "/" + this.id++ + ".png"), StandardCopyOption.REPLACE_EXISTING);
        }
        part.delete();
        res.sendRedirect("01");
   }

}
