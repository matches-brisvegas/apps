package net.mjc.controller;

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
    @RequestMapping("/bye/{name}")
    @Produces("text/plain")
    @ResponseBody
    public String bye(@PathVariable String name) {
        System.out.println("bye " + name);
        return "Bye " + name;
    }

    @GET
    @RequestMapping("/bye")
    @Produces("text/plain")
    @ResponseBody
    public String bye() {
        System.out.println("bye");
        return "Bye";
    }
}
