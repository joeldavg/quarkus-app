package com.joeldavg.quarkus.domain.user.gateway;

import com.joeldavg.quarkus.domain.user.model.User;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface UserGateway {

    Multi<User> listUsers();

    Uni<User> findUserById(long id);

    Multi<User> findUserByName(String name);

}
