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

    public Education update(String id, Education updatedData) {
        Education existingEducation = getById(id);
        if (existingEducation != null) {
            if (updatedData.getTitle() != null) {
                existingEducation.setTitle(updatedData.getTitle());
            }
            if (updatedData.getInstitute() != null) {
                existingEducation.setInstitute(updatedData.getInstitute());
            }
            if (updatedData.getType() != null) {
                existingEducation.setType(updatedData.getType());
            }
            if (updatedData.getDescription() != null) {
                existingEducation.setDescription(updatedData.getDescription());
            }
            if (updatedData.getTechnologies() != null) {
                existingEducation.setTechnologies(updatedData.getTechnologies());
            }
            if (updatedData.getDateStart() != null) {
                existingEducation.setDateStart(updatedData.getDateStart());
            }
            if (updatedData.getDateEnd() != null) {
                existingEducation.setDateEnd(updatedData.getDateEnd());
            }
            if (updatedData.getAcademic() != null) {
                existingEducation.setAcademic(updatedData.getAcademic());
            }
            if (updatedData.getAdditionalInfo() != null) {
                existingEducation.setAdditionalInfo(updatedData.getAdditionalInfo());
            }

            // Persistindo o objeto atualizado
            educationRepository.update(existingEducation);
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
