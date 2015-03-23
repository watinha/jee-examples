package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.ResourceBundle;

public class Servlet2 extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        PrintWriter writer = res.getWriter();
        ResourceBundle rb = (ResourceBundle) req.getAttribute("rb");
        writer.println(rb.getString("SERVLET2_NAME"));
    }
}
