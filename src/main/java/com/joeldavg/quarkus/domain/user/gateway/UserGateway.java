package com.joeldavg.quarkus.domain.user.gateway;

import com.joeldavg.quarkus.domain.user.model.User;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface UserGateway {

    Uni<List<User>> listUsers();

    Uni<User> findUserById(long id);

    Uni<List<User>> findUserByName(String name);

    Uni<User> createUser(User user);

}
