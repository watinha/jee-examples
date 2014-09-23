package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.ArrayList;

public class Hello extends HttpServlet {

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res) throws IOException {
        ArrayList <String> list = new ArrayList <String> ();
        list.add("Abobrinha");
        list.add("Pepino");
        list.add("Melão");

        res.getWriter().print("[");
        String buffer = "";
        for (String fruta : list)
            buffer += "\"" + fruta + "\",";
        res.getWriter().print(buffer.substring(0, buffer.length() - 1));
        res.getWriter().print("]");
    }

}
