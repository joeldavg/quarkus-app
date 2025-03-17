package com.joeldavg.quarkus.repository.user;

import com.joeldavg.quarkus.domain.user.gateway.UserGateway;
import com.joeldavg.quarkus.domain.user.model.User;
import com.joeldavg.quarkus.repository.user.mapper.UserMapper;
import com.joeldavg.quarkus.repository.user.panache.UserRepository;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserAdapter implements UserGateway {

    @Inject
    private UserRepository userRepository;

    @Override
    @WithTransaction
    public Uni<List<User>> listUsers() {
        return this.userRepository.listAll()
                .map(UserMapper::toModel);
    }

    @Override
    @WithTransaction
    public Uni<User> findUserById(long id) {
        return this.userRepository.findById(id)
                .map(UserMapper::toModel);
    }

    @Override
    @WithTransaction
    public Uni<List<User>> findUserByName(String name) {
        return this.userRepository.find("name", name)
                .list()
                .map(UserMapper::toModel);
    }

    @Override
    @WithTransaction
    public Uni<User> createUser(User user) {
        var entity = UserMapper.toEntity(user);
        return this.userRepository.persist(entity)
                .map(UserMapper::toModel);
    }

}
