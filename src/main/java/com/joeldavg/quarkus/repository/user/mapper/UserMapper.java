package com.joeldavg.quarkus.repository.user.mapper;

import com.joeldavg.quarkus.domain.user.model.User;
import com.joeldavg.quarkus.repository.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .name(user.getName())
                .age(user.getAge())
                .email(user.getEmail())
                .build();
    }

    public static List<UserEntity> toEntity(List<User> users) {
        return users.stream()
                .map(UserMapper::toEntity)
                .toList();
    }

    public static User toModel(UserEntity entity) {
        return Optional.ofNullable(entity)
                .map(entity1 -> User.builder()
                        .name(entity1.getName())
                        .age(entity1.getAge())
                        .email(entity1.getEmail())
                        .build())
                .orElseGet(() -> null);
    }

    public static List<User> toModel(List<UserEntity> entities) {
        return entities.stream()
                .map(UserMapper::toModel)
                .toList();
    }

}
