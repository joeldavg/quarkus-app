package com.joeldavg.quarkus.service.user;

import com.joeldavg.quarkus.domain.user.model.User;
import com.joeldavg.quarkus.repository.user.UserAdapter;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FindUserByNameService {

    @Inject
    private UserAdapter userAdapter;

    public Multi<User> findUserByName(String name) {
        return this.userAdapter.findUserByName(name)
                .map(user -> {
                    user.setName(user.getName().toUpperCase());
                    return user;
                });
    }

}
