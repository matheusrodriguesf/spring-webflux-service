package br.com.arcelino.webfluxcourse.model.request;

public record UserRequest(
        String name,
        String email,
        Integer age) {
}