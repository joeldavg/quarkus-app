package com.joeldavg.quarkus.service.user;

import com.joeldavg.quarkus.domain.user.gateway.UserGateway;
import com.joeldavg.quarkus.domain.user.model.User;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreateUserService {

    @Inject
    private UserGateway userGateway;

    public Uni<User> createUser(User user) {
        return this.userGateway.createUser(user);
    }

}
