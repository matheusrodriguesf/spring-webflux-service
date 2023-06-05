package br.com.arcelino.webfluxcourse.service;

import org.springframework.stereotype.Service;

import br.com.arcelino.webfluxcourse.entity.User;
import br.com.arcelino.webfluxcourse.mapper.UserMapper;
import br.com.arcelino.webfluxcourse.model.request.UserRequest;
import br.com.arcelino.webfluxcourse.model.response.UserResponse;
import br.com.arcelino.webfluxcourse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest userRequest) {
        return repository.save(mapper.toEntity(userRequest));
    }

    public Mono<UserResponse> findById(final String id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    public Flux<UserResponse> findAll() {
        return repository.findAll().map(mapper::toResponse);
    }

    public Mono<UserResponse> update(final String id, final UserRequest userRequest) {
        return repository.findById(id)
                .map(user -> mapper.toEntity(userRequest, user))
                .flatMap(repository::save)
                .map(mapper::toResponse);

    }

    public Mono<User> delete(final String id) {
        return repository.deleteById(id);

    }
}
