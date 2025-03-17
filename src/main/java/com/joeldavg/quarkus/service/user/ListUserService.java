package com.joeldavg.quarkus.service.user;

import com.joeldavg.quarkus.domain.user.gateway.UserGateway;
import com.joeldavg.quarkus.domain.user.model.User;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ListUserService {

    @Inject
    private UserGateway userGateway;

    public Multi<User> listUsers() {
        return this.userGateway.listUsers()
                .map(user -> {
                    user.setName(user.getName().toUpperCase());
                    return user;
                });
    }

}
