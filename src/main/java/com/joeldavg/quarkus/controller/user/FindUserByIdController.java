package com.joeldavg.quarkus.controller.user;

import com.joeldavg.quarkus.service.user.FindUserByIdService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Path(value = "user")
@Produces(value = MediaType.APPLICATION_JSON)
public class FindUserByIdController {

    @Inject
    private FindUserByIdService service;

    @GET
    @Path(value = "id/{id}")
    public Uni<Response> findUserById(@PathParam(value = "id") long id) {
        log.info("REQUEST -> findUserById, PathParam -> id: " + id);
        return this.service.findUserById(id)
                .invoke(user -> log.info("RESPONSE -> findUserById, User:  " + user))
                .map(user -> Optional.ofNullable(user)
                        .map(Response::ok)
                        .orElseGet(() -> Response.status(Status.NOT_FOUND)))
                .onItem().transform(Response.ResponseBuilder::build);
    }

}
