package de.say.adapter.incoming;

import de.say.application.port.incoming.CustomerUseCase;
import de.say.domain.Customer;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("customers")
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers() {
        return Response.ok(
                this.customerUseCase.getCustomers(),
                MediaType.APPLICATION_JSON_TYPE
        ).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {
        this.customerUseCase.createCustomer(customer);
        return Response.ok(
                customer.getUuid()
        ).build();
    }

    @DELETE
    @Path("/{uuid}")
    public Response deleteCustomer(@PathParam("uuid") UUID uuid) {
        this.customerUseCase.deleteCustomer(uuid);
        return Response.ok().build();
    }

}
