package filters;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.ServletException;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class MachineCommentsFilter implements Filter {

    public void init (FilterConfig config) {}
    public void destroy () {}

    public void doFilter (ServletRequest req,
                          ServletResponse res,
                          FilterChain chain) throws IOException, ServletException {
        res.setContentType("text/html");

        chain.doFilter(req, res);

        String machineInformation = "User: " + System.getProperty("user.name");
        res.getWriter().println("<!-- " + machineInformation + " -->\n");
        machineInformation = "OS: " + System.getProperty("os.name");
        res.getWriter().println("<!-- " + machineInformation + " -->\n");
        machineInformation = "OS arch: " + System.getProperty("os.arch");
        res.getWriter().println("<!-- " + machineInformation + " -->\n");
        machineInformation = "OS version: " + System.getProperty("os.version");
        res.getWriter().println("<!-- " + machineInformation + " -->\n");

        NetworkInterface netInterface = NetworkInterface.getByName("en0");
        res.getWriter().println("<!-- " + netInterface.toString() + " -->\n");

        Enumeration <InetAddress> list = netInterface.getInetAddresses();
        while(list.hasMoreElements())
            res.getWriter().println("<!-- IP: " + list.nextElement().toString() + " -->\n");
    }

}
