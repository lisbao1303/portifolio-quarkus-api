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
            existingUserPublicData.name = userPublicData.name;
            existingUserPublicData.title = userPublicData.title;
            existingUserPublicData.about = userPublicData.about;
            existingUserPublicData.birth = userPublicData.birth;
            existingUserPublicData.birthPlace = userPublicData.birthPlace;
            existingUserPublicData.email = userPublicData.email;
            existingUserPublicData.phone = userPublicData.phone;
            existingUserPublicData.adress = userPublicData.adress;
            existingUserPublicData.github = userPublicData.github;
            existingUserPublicData.linkedin = userPublicData.linkedin;
            existingUserPublicData.pricipalTech = userPublicData.pricipalTech;
            existingUserPublicData.skills = userPublicData.skills;
            existingUserPublicData.adicionalInfo = userPublicData.adicionalInfo;
            userPublicDataRepository.persist(existingUserPublicData);
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
