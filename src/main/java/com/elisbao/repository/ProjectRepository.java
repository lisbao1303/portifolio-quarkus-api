package com.elisbao.repository;

import com.elisbao.model.Project;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProjectRepository implements PanacheMongoRepository<Project> {

}