package filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

public class ProtetorFilter implements Filter {

    public void destroy () {}
    public void init (FilterConfig config) {}
    public void doFilter (ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        if (req.getHeader("Accept-Language").contains("it"))
            res.sendRedirect("./1");
    }
}
