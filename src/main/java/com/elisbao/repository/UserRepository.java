package com.elisbao.repository;

import com.elisbao.model.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {
    // Métodos customizados podem ser adicionados aqui
}
