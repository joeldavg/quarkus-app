package com.joeldavg.quarkus.service.user;

import com.joeldavg.quarkus.domain.user.model.User;
import com.joeldavg.quarkus.repository.user.UserAdapter;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FindUserByNameService {

    @Inject
    private UserAdapter userAdapter;

    public Uni<List<User>> findUserByName(String name) {
        return this.userAdapter.findUserByName(name);
    }

}
