package com.elisbao.repository;

import com.elisbao.model.UserPublicData;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserPublicDataRepository implements PanacheMongoRepository<UserPublicData> {

}
