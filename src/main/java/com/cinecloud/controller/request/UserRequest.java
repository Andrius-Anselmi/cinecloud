package com.cinecloud.controller.request;

public record UserRequest(
        String name,
        String email,
        String password
) {
}
