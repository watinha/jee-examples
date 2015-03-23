package filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

import java.util.ResourceBundle;
import java.io.IOException;

public class I18nFilter implements Filter {

    public void destroy () {}
    public void init (FilterConfig config) {}
    public void doFilter (ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        ResourceBundle rb = ResourceBundle.getBundle("resources.geral",
                req.getLocale());
        req.setAttribute("rb", rb);
        chain.doFilter(req, res);
    }

}
