package com.elisbao.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

public class User extends PanacheMongoEntity {
    public String name;
    public String email;

    // Construtor vazio necessário para o Panache
    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
