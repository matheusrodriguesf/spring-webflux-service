package br.com.arcelino.webfluxcourse.repository;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import br.com.arcelino.webfluxcourse.entity.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public Mono<User> save(final User user) {
        return reactiveMongoTemplate.save(user);
    }

    public Mono<User> findById(final String id) {
        return reactiveMongoTemplate.findById(id, User.class);
    }

    public Flux<User> findAll() {
        return reactiveMongoTemplate.findAll(User.class);
    }

    public Mono<User> deleteById(final String id) {
        var query = Query.query(Criteria.where("id").is(id));
        return reactiveMongoTemplate.findAndRemove(query, User.class);
    }
}
