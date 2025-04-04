package com.joeldavg.quarkus.service.user;

import com.joeldavg.quarkus.domain.user.gateway.UserGateway;
import com.joeldavg.quarkus.domain.user.model.User;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ListUserService {

    @Inject
    private UserGateway userGateway;

    public Uni<List<User>> listUsers() {
        return this.userGateway.listUsers();
    }

}
