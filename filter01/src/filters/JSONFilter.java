package filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.io.IOException;
import java.util.Locale;

public class JSONFilter implements Filter {

    public void init (FilterConfig config) {}
    public void destroy () {}

    public void doFilter (ServletRequest req,
                          ServletResponse res,
                          FilterChain chain) throws IOException, ServletException {
        res.setContentType("application/json");
        Locale loc = new Locale("pt", "br");
        res.setLocale(loc);
        chain.doFilter(req, res);
    }

}
