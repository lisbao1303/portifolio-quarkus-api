package com.elisbao.model;

import com.elisbao.model.object.Skill;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.time.LocalDate;
import java.util.List;

public class UserPublicData extends PanacheMongoEntity {
    public String name;
    public String title;
    public String about;
    public LocalDate birth;
    public String birthPlace;
    public String email;
    public String phone;
    public String adress;
    public String github;
    public String linkedin;
    public List<String> pricipalTech;
    public List<Skill> skills;
    public String adicionalInfo;

    public UserPublicData() {
    }

}
