package com.joeldavg.quarkus.controller.user;

import com.joeldavg.quarkus.domain.user.model.User;
import com.joeldavg.quarkus.service.user.FindUserByNameService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Path(value = "user")
@Produces(value = MediaType.APPLICATION_JSON)
public class FindUserByNameController {

    @Inject
    private FindUserByNameService service;

    @GET
    @Path(value = "find-by-name")
    public Uni<List<User>> findUserByName(@QueryParam(value = "name") String name) {
        log.info("REQUEST -> findUserByName, QueryParam -> name: ".concat(name));
        return this.service.findUserByName(name);
    }

}
