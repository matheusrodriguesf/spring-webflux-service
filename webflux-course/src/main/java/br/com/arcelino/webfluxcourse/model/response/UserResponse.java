package br.com.arcelino.webfluxcourse.model.response;

public record UserResponse(
        String id,
        String name,
        String email,
        Integer age) {
}
