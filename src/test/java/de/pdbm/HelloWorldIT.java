package de.pdbm;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldIT {

    @Test
    public void getHelloWorld() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/starter/api/helloworld");
        Response response = target.request(MediaType.APPLICATION_JSON).get(Response.class);

        assertEquals(200, response.getStatus());
/*        assertEquals(
                Json.createObjectBuilder().add("message", "Hello World"),
                response.readEntity(String.class)
        );*/
    }

}
