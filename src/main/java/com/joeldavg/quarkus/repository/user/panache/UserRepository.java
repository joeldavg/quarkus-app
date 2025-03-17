package com.joeldavg.quarkus.repository.user.panache;

import com.joeldavg.quarkus.repository.user.entity.UserEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<UserEntity, Long> {

}
