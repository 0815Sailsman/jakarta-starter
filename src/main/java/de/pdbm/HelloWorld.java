package de.pdbm;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("helloworld")
public class HelloWorld {

    @GET
    public String helloWorld() {
        return "Hello World abc!";
    }

}
