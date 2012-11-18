package net.mjc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * NOTE
 * by calling this class xxxController and using ControllerClassNameHandlerMapping is the
 * web context setup means some of the url mapping is done.
 */
@Controller
public class ByeController {

    @GET
    @RequestMapping("/{name}")
    @Produces("text/plain")
    @ResponseBody
    public String bye(@PathVariable String name) {
        System.out.println("bye " + name);
        return "Bye " + name + ", Spring 3.0!";
    }
}
