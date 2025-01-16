package com.elisbao.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

public class User extends PanacheMongoEntity {
    private ObjectId id;
    private String name;
    private String email;

    // Construtor vazio necessário para o Panache
    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
