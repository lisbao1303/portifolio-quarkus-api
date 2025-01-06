package com.elisbao.model;

import com.elisbao.model.object.AcademicAds;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.time.LocalDate;
import java.util.List;

public class Education extends PanacheMongoEntity {
    public String title;
    public String institute;
    public String type;
    public String description;
    public List<String> tecnologies;
    public LocalDate dateStart;
    public LocalDate dateEnd;
    public List<AcademicAds> academic;
    public String adicionalInfo;


    public Education() {
    }


}
