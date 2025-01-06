package com.elisbao.service;

import com.elisbao.model.Project;
import com.elisbao.repository.ProjectRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
public class ProjectService {

    @Inject
    ProjectRepository projectRepository;

    public List<Project> getAll() {
        return projectRepository.listAll();
    }

    // Find experience by ID
    public Project getById(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            return projectRepository.findById(objectId);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid ID: " + id, e);
        }
    }

    public Project create(Project project) {
        projectRepository.persist(project);
        return project;
    }

    public Project update(String id, Project project) {
        Project existingProject = Project.findById(id);
        if (existingProject != null) {
            existingProject.name = project.name;
            existingProject.description = project.description;
            existingProject.tecnologies = project.tecnologies;
            existingProject.link_repository = project.link_repository;
            existingProject.link_demo = project.link_demo;
            existingProject.dateStart = project.dateStart;
            existingProject.dateEnd = project.dateEnd;
            existingProject.adicionalInfo = project.adicionalInfo;
            existingProject.persist();
        }
        return existingProject;
    }

    public boolean delete(String id) {
        Project project = projectRepository.findById(new ObjectId(id));
        if (project != null) {
            project.delete();
            return true;
        }
        return false;
    }
}
