package com.elisbao.repository;

import com.elisbao.model.Education;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EducationRepository implements PanacheMongoRepository<Education> {

}