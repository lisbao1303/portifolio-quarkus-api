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

    // Update an existing experience
    public Experience update(String id, Experience updatedData) {
        Experience existingExperience = getById(id);
        if (existingExperience != null) {
            existingExperience.company = updatedData.company;
            existingExperience.position = updatedData.position;
            existingExperience.description = updatedData.description;
            existingExperience.technologies = updatedData.technologies;
            existingExperience.dateStart = updatedData.dateStart;
            existingExperience.dateEnd = updatedData.dateEnd;
            existingExperience.adicionalInfo = updatedData.adicionalInfo;
            experienceRepository.persist(existingExperience);
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
