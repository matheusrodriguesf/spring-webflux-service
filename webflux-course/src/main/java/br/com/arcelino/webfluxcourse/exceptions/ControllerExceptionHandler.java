package br.com.arcelino.webfluxcourse.exceptions;

import java.time.LocalDateTime;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import reactor.core.publisher.Mono;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Mono<StandardError>> handleDuplicateKeyException(DuplicateKeyException ex,
            ServerHttpRequest request) {
        StandardError error = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(verifyDuplicateKeyExceptionMessage(ex.getMessage()))
                .path(request.getPath().toString())
                .build();
        return ResponseEntity.badRequest().body(Mono.just(error));
    }

    private String verifyDuplicateKeyExceptionMessage(String message) {
        return message.contains("email dup key") ? "Email já cadastrado" : message;
    }

}
