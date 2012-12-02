package net.mjc.jetty;

import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.servlets.ProxyServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class FwdProxyServlet extends ProxyServlet.Transparent {

    public FwdProxyServlet() {
        super();
    }

    public FwdProxyServlet(String prefix, String host, int port) {
        super(prefix, host, port);
    }

    public FwdProxyServlet(String prefix, String schema, String host, int port, String path) {
        super(prefix, schema, host, port, path);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
    {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        System.out.println("httpReq.getRequestURI() = " + httpReq.getRequestURI());

        Enumeration<String> headers = httpReq.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            System.out.println("httpReq.(header) " + header + " = " + httpReq.getHeader(header));
        }

        super.service(req, res);
    }

    @Override
    protected void customizeExchange(HttpExchange exchange, HttpServletRequest request)
    {
        System.out.println("FwdProxyServlet.customizeExchange");
        exchange.addRequestHeader("MATT", "WAS HERE");
        exchange.getRequestFields().remove("Host");

        Enumeration<String> headers = exchange.getRequestFields().getFieldNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            System.out.println("exchange(header) " + header + " = " + exchange.getRequestFields().getStringField(header));
        }
    }
}