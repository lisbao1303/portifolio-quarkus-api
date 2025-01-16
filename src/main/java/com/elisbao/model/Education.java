package com.elisbao.model;

import com.elisbao.model.object.AcademicAds;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

public class Education extends PanacheMongoEntity {
    private ObjectId id;
    private String title;
    private String institute;
    private String type;
    private String description;
    private List<String> technologies;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private List<AcademicAds> academic;
    private String additionalInfo;


    public Education() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<AcademicAds> getAcademic() {
        return academic;
    }

    public void setAcademic(List<AcademicAds> academic) {
        this.academic = academic;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
