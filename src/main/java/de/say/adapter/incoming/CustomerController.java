package de.say.adapter.incoming;

import de.say.application.port.incoming.CustomerUseCase;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("customer")
public class CustomerController {

    private static Jsonb jsonb = JsonbBuilder.create();

    @Inject
    private CustomerUseCase customerUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{uuid}")
    public Response getCustomer(@PathParam("uuid") UUID uuid) {
        return Response.ok(
                this.customerUseCase.getCustomerOrNull(uuid),
                MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

}
