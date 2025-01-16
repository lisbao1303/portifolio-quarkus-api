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
            if (project.getName() != null) {
                existingProject.setName(project.getName());
            }
            if (project.getDescription() != null) {
                existingProject.setDescription(project.getDescription());
            }
            if (project.getTechnologies() != null) {
                existingProject.setTechnologies(project.getTechnologies());
            }
            if (project.getLinkRepository() != null) {
                existingProject.setLinkRepository(project.getLinkRepository());
            }
            if (project.getLinkDemo() != null) {
                existingProject.setLinkDemo(project.getLinkDemo());
            }
            if (project.getDateStart() != null) {
                existingProject.setDateStart(project.getDateStart());
            }
            if (project.getDateEnd() != null) {
                existingProject.setDateEnd(project.getDateEnd());
            }
            if (project.getAdditionalInfo() != null) {
                existingProject.setAdditionalInfo(project.getAdditionalInfo());
            }

            // Persistir as alterações
            projectRepository.update(existingProject);
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
