package com.cinecloud.mapper;

import com.cinecloud.controller.request.UserRequest;
import com.cinecloud.controller.response.UserResponse;
import com.cinecloud.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request){
        return User.builder()
                .username(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
