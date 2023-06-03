package br.com.arcelino.webfluxcourse.service;

import org.springframework.stereotype.Service;

import br.com.arcelino.webfluxcourse.entity.User;
import br.com.arcelino.webfluxcourse.mapper.UserMapper;
import br.com.arcelino.webfluxcourse.model.request.UserRequest;
import br.com.arcelino.webfluxcourse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest userRequest) {
        return repository.save(mapper.toEntity(userRequest));
    }
}