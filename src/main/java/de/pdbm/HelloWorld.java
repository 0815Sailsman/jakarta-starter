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
        JsonObject result = Json.createObjectBuilder()
                .add("message", "Hello World")
                .build();
        return Response.ok(
                result,
                MediaType.APPLICATION_JSON_TYPE).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        return Response.noContent().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(JsonObject json) {
        JsonObject result = Json.createObjectBuilder()
                .add("message", "Hello put")
                .add("input", json)
                .build();
        return Response.ok(result, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(JsonObject json) {
        JsonObject result = Json.createObjectBuilder()
                .add("message", "Hello post")
                .add("input", json)
                .build();
        return Response.ok(result, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    public Response patch(JsonObject json) {
        JsonObject result = Json.createObjectBuilder()
                .add("message", "Hello patch")
                .add("input", json)
                .build();
        return Response.ok(result, MediaType.APPLICATION_JSON_TYPE).build();
    }

}
