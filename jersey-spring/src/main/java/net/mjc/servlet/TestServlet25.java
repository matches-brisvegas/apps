package net.mjc.servlet;

import net.mjc.bean.TestBean;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet25 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private TestBean bean;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        bean = WebApplicationContextUtils.
                getRequiredWebApplicationContext(config.getServletContext()).
                getBean(TestBean.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        final PrintWriter writer = resp.getWriter();
        final String requestURI = req.getRequestURI();
        writer.write(this.getClass().getCanonicalName() + " " + bean.toString() + " " + requestURI);
    }
}