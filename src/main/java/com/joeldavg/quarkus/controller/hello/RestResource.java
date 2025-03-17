package com.joeldavg.quarkus.controller.hello;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path(value = "/hello")
public class RestResource {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public String hello() {
        return "Hello from Quarkus REST!";
    }

}
