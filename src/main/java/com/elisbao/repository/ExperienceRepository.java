package com.elisbao.repository;

import com.elisbao.model.Experience;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExperienceRepository implements PanacheMongoRepository<Experience> {

}