package com.redhat.gpte.training.springboot_cxfrs_rest;

import org.globex.Account;

import javax.ws.rs.*;

@Path("/customerservice")
public interface CustomerRest {

    @POST @Path("/enrich") @Consumes("application/json") @Produces("application/json")
    Account enrich(Account customer);

}
