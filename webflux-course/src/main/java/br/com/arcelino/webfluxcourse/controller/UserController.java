package br.com.arcelino.webfluxcourse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.arcelino.webfluxcourse.model.request.UserRequest;
import br.com.arcelino.webfluxcourse.model.response.UserResponse;
import br.com.arcelino.webfluxcourse.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> save(@Valid @RequestBody UserRequest userRequest) {
        return userService.save(userRequest).then();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<UserResponse>> findById(@PathVariable String id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Flux<UserResponse>> findAll() {
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Mono<UserResponse>> update(@PathVariable String id, @RequestBody UserRequest userRequest) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable String id) {
        return null;
    }

}
