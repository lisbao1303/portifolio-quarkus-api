package com.elisbao.service;

import com.elisbao.model.UserPublicData;
import com.elisbao.repository.UserPublicDataRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
public class UserPublicDataService {

    @Inject
    UserPublicDataRepository userPublicDataRepository;

    // List all user public data
    public List<UserPublicData> listUserPublicDatas() {
        return userPublicDataRepository.listAll();
    }

    // Get user public data by ID
    public UserPublicData getById(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            return userPublicDataRepository.findById(objectId);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid ID: " + id, e);
        }
    }

    // Create a new user public data
    public UserPublicData createUserPublicData(UserPublicData userPublicData) {
        userPublicDataRepository.persist(userPublicData);
        return userPublicData;
    }

    // Update an existing user public data
    public UserPublicData updateUserPublicData(String id, UserPublicData userPublicData) {
        UserPublicData existingUserPublicData = getById(id);
        if (existingUserPublicData != null) {
            if (userPublicData.getName() != null) {
                existingUserPublicData.setName(userPublicData.getName());
            }
            if (userPublicData.getTitle() != null) {
                existingUserPublicData.setTitle(userPublicData.getTitle());
            }
            if (userPublicData.getAbout() != null) {
                existingUserPublicData.setAbout(userPublicData.getAbout());
            }
            if (userPublicData.getBirth() != null) {
                existingUserPublicData.setBirth(userPublicData.getBirth());
            }
            if (userPublicData.getBirthPlace() != null) {
                existingUserPublicData.setBirthPlace(userPublicData.getBirthPlace());
            }
            if (userPublicData.getEmail() != null) {
                existingUserPublicData.setEmail(userPublicData.getEmail());
            }
            if (userPublicData.getPhone() != null) {
                existingUserPublicData.setPhone(userPublicData.getPhone());
            }
            if (userPublicData.getAddress() != null) {
                existingUserPublicData.setAddress(userPublicData.getAddress());
            }
            if (userPublicData.getGithub() != null) {
                existingUserPublicData.setGithub(userPublicData.getGithub());
            }
            if (userPublicData.getLinkedin() != null) {
                existingUserPublicData.setLinkedin(userPublicData.getLinkedin());
            }
            if (userPublicData.getPrincipalTech() != null) {
                existingUserPublicData.setPrincipalTech(userPublicData.getPrincipalTech());
            }
            if (userPublicData.getSkills() != null) {
                existingUserPublicData.setSkills(userPublicData.getSkills());
            }
            if (userPublicData.getAdditionalInfo() != null) {
                existingUserPublicData.setAdditionalInfo(userPublicData.getAdditionalInfo());
            }
            userPublicDataRepository.update(existingUserPublicData);
        }
        return existingUserPublicData;
    }


    // Delete a user public data
    public boolean deleteUserPublicData(String id) {
        UserPublicData userPublicData = getById(id);
        if (userPublicData != null) {
            userPublicData.delete();
            return true;
        }
        return false;
    }
}
