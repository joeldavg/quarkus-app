package com.joeldavg.quarkus.repository.user;

import com.joeldavg.quarkus.domain.user.gateway.UserGateway;
import com.joeldavg.quarkus.domain.user.model.User;
import com.joeldavg.quarkus.repository.user.entity.UserEntity;
import com.joeldavg.quarkus.repository.user.panache.UserRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserAdapter implements UserGateway {

    @Inject
    private UserRepository userRepository;

    private final static List<User> USER_LIST = List.of(
            new User("Joel", 27, "joel@mail.com"),
            new User("Majo", 29, "majo@mail.com")
    );

    @Override
    public Multi<User> listUsers() {
        return userRepository.listAll()
                .toMulti()
                .flatMap(userList -> Multi.createFrom().items(userList.stream()))
                .map(this::toModel);
    }

    @Override
    public Uni<User> findUserById(long id) {
        return null;
    }

    @Override
    public Multi<User> findUserByName(String name) {
        return Multi.createFrom().items(USER_LIST.stream())
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()));
    }

    private User toModel(UserEntity entity) {
        return User.builder()
                .name(entity.getName())
                .age(entity.getAge())
                .email(entity.getEmail())
                .build();
    }

}
