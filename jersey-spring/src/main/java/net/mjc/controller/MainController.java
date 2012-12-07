package net.mjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Controller
public class MainController {

//    uncomment to take over root endpoint
//    @RequestMapping("/")
    @RequestMapping("/main")
    @Produces("text/plain")
    @ResponseBody
    @GET
    public String mainPage() {
        System.out.println("mainPage");
        return "Main";
    }
}
