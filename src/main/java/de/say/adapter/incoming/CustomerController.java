package de.say.adapter.incoming;

import de.say.application.port.incoming.CustomerUseCase;
import de.say.domain.Customer;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customers")
public class CustomerController {

    private static Jsonb jsonb = JsonbBuilder.create();

    @Inject
    private CustomerUseCase customerUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") int id) {
        return Response.ok(
                this.customerUseCase.getCustomerOrNull(id),
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
                customer.getCustomer_id()
        ).build();
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") int id, Customer customer) {
        this.customerUseCase.updateCustomer(id, customer);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        this.customerUseCase.deleteCustomer(id);
        return Response.ok().build();
    }

}
