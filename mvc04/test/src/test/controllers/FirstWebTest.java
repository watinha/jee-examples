package test.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;

import controllers.FirstWeb;

@RunWith(JUnit4.class)
public class FirstWebTest {

    @Test
    public void test_dummy_servlet () throws IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        PrintWriter writer = mock(PrintWriter.class);

        when(response.getWriter()).thenReturn(writer);

        FirstWeb controller = new FirstWeb();
        controller.doGet(request, response);

        verify(writer).println("<h1>Hello world servlet!</h1>");
    }

}
