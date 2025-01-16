package com.elisbao.model;

import com.elisbao.model.object.Skill;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

public class UserPublicData extends PanacheMongoEntity {
    private ObjectId id;
    private String name;
    private String title;
    private String about;
    private LocalDate birth;
    private String birthPlace;
    private String email;
    private String phone;
    private String address;
    private String github;
    private String linkedin;
    private List<String> principalTech;
    private List<Skill> skills;
    private String additionalInfo;

    public UserPublicData() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public List<String> getPrincipalTech() {
        return principalTech;
    }

    public void setPrincipalTech(List<String> principalTech) {
        this.principalTech = principalTech;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
