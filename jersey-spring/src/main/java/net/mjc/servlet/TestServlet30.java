package net.mjc.servlet;

import net.mjc.bean.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="servlet30", urlPatterns = { "/servlet30/*" })
public class TestServlet30 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Autowired
    TestBean bean;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        final PrintWriter writer = resp.getWriter();
        final String requestURI = req.getRequestURI();
        writer.write(this.getClass().getCanonicalName() + " " + bean.toString() + " " + requestURI);
    }
}