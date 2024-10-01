package de.pdbm;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.logging.Logger;

@Path("helloworld")
public class HelloWorld {

    private static final Logger LOGGER  = Logger.getLogger(HelloWorld.class.getCanonicalName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloWorld() {
        return Response.ok(toJson("Hello World abc!"), MediaType.APPLICATION_JSON_TYPE).build();
    }

    @DELETE
    public Response delete() {
        return Response.noContent().build();
    }

    @PUT
    public Response put(JsonObject json) {
        System.out.println(json);
        return Response.ok().build();
    }

    private JsonObject toJson(String message) {
        return Json.createObjectBuilder().add("message", message).build();
    }

}
