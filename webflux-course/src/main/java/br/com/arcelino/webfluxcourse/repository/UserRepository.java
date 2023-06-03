package br.com.arcelino.webfluxcourse.repository;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;

import br.com.arcelino.webfluxcourse.entity.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public Mono<User> save(final User user) {
        return reactiveMongoTemplate.save(user);
    }

}