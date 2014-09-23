package filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class LoginFilter implements Filter {

    public void init (FilterConfig config) { }

    public void doFilter (ServletRequest request,
                          ServletResponse response,
                          FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession();
        String login = (String) session.getAttribute("login");
        if (login != null) {
            chain.doFilter(request, response);
        } else {
            if (((HttpServletRequest)request).getRequestURL().equals("/"))
                ((HttpServletResponse)response).sendRedirect("/abobrinha");
            else
                ((HttpServletResponse)response).sendRedirect("/");
        }
    }

    public void destroy () { }
}
