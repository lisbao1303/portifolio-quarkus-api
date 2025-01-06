package com.elisbao.service;

import com.elisbao.model.Education;
import com.elisbao.repository.EducationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import org.bson.types.ObjectId;

@ApplicationScoped
public class EducationService {

    @Inject
    EducationRepository educationRepository;

    // List all educations
    public List<Education> getAll() {
        return educationRepository.listAll();
    }

    // Find education by ID
    public Education getById(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            return educationRepository.findById(objectId);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid ID: " + id, e);
        }
    }

    // Create a new education
    public Education create(Education education) {
        educationRepository.persist(education);
        return education;
    }

    // Update an existing education
    public Education update(String id, Education updatedData) {
        Education existingEducation = getById(id);
        if (existingEducation != null) {
            existingEducation.title = updatedData.title;
            existingEducation.institute = updatedData.institute;
            existingEducation.type = updatedData.type;
            existingEducation.description = updatedData.description;
            existingEducation.tecnologies = updatedData.tecnologies;
            existingEducation.dateStart = updatedData.dateStart;
            existingEducation.dateEnd = updatedData.dateEnd;
            existingEducation.academic = updatedData.academic;
            existingEducation.adicionalInfo = updatedData.adicionalInfo;
            educationRepository.persist(existingEducation);
        }
        return existingEducation;
    }

    // Delete education by ID
    public boolean delete(String id) {
        Education existingEducation = getById(id);
        if (existingEducation != null) {
            educationRepository.delete(existingEducation);
            return true;
        }
        return false;
    }
}
