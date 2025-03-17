package com.joeldavg.quarkus.service.user;

import com.joeldavg.quarkus.domain.user.gateway.UserGateway;
import com.joeldavg.quarkus.domain.user.model.User;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FindUserByIdService {

    @Inject
    private UserGateway userGateway;

    public Uni<User> findUserById(long id) {
        return this.userGateway.findUserById(id);
    }

}
