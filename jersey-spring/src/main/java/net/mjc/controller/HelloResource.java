package net.mjc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.io.IOException;

@Controller
public class HelloResource {

    @GET
    @RequestMapping("/hello/{name}")
    @Produces("text/plain")
    @ResponseBody
    public String hello(@PathVariable String name) {
        System.out.println("hello " + name);
        return "Hello " + name + ", Spring 3.0!";
    }

    @GET
    @RequestMapping("/hi/{name}")
    @Produces("text/plain")
    @ResponseBody
    public ResponseEntity<String> hi(@PathVariable String name)
    {
        System.out.println("hi " + name);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Hi", name);
        return new ResponseEntity<String>("Hi " + name + ", Spring 3.0!", responseHeaders, HttpStatus.OK);
    }


  @ExceptionHandler(ResourceNotFoundException.class)
  public void handleException(ResourceNotFoundException ex, HttpServletResponse response) throws IOException
  {
    response.sendError(HttpStatus.NOT_FOUND.value(), "Not found for: " + ex.name);
  }

  private class ResourceNotFoundException extends RuntimeException {
    private String name;

    public ResourceNotFoundException(String name) {
      this.name = name;
    }
  }

}
