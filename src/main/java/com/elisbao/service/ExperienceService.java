package com.elisbao.service;

import com.elisbao.model.Experience;
import com.elisbao.repository.ExperienceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import org.bson.types.ObjectId;

@ApplicationScoped
public class ExperienceService {

    @Inject
    ExperienceRepository experienceRepository;

    // List all experiences
    public List<Experience> getAll() {
        return experienceRepository.listAll();
    }

    // Find experience by ID
    public Experience getById(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            return experienceRepository.findById(objectId);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid ID: " + id, e);
        }
    }

    // Create a new experience
    public Experience create(Experience experience) {
        experienceRepository.persist(experience);
        return experience;
    }

    public Experience update(String id, Experience updatedData) {
        Experience existingExperience = getById(id);
        if (existingExperience != null) {
            if (updatedData.getCompany() != null) {
                existingExperience.setCompany(updatedData.getCompany());
            }
            if (updatedData.getPosition() != null) {
                existingExperience.setPosition(updatedData.getPosition());
            }
            if (updatedData.getLocation() != null) {
                existingExperience.setLocation(updatedData.getLocation());
            }
            if (updatedData.getDescription() != null) {
                existingExperience.setDescription(updatedData.getDescription());
            }
            if (updatedData.getTechnologies() != null) {
                existingExperience.setTechnologies(updatedData.getTechnologies());
            }
            if (updatedData.getDateStart() != null) {
                existingExperience.setDateStart(updatedData.getDateStart());
            }
            if (updatedData.getDateEnd() != null) {
                existingExperience.setDateEnd(updatedData.getDateEnd());
            }
            if (updatedData.getAdditionalInfo() != null) {
                existingExperience.setAdditionalInfo(updatedData.getAdditionalInfo());
            }

            // Persistindo o objeto atualizado
            experienceRepository.update(existingExperience);
        }
        return existingExperience;
    }

    // Delete experience by ID
    public boolean delete(String id) {
        Experience existingExperience = getById(id);
        if (existingExperience != null) {
            experienceRepository.delete(existingExperience);
            return true;
        }
        return false;
    }
}
