
package com.elisbao.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

public class Experience extends PanacheMongoEntity {
    private ObjectId id;
    private String company;
    private String position;
    private String location;
    private String description;
    private List<String> technologies;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String additionalInfo;

    public Experience() {
    }

    public Experience(
            String company,
            String position,
            String description,
            LocalDate dateStart,
            String additionalInfo,
            LocalDate dateEnd,
            List<String> technologies) {
        this.company = company;
        this.position = position;
        this.description = description;
        this.dateStart = dateStart;
        this.additionalInfo = additionalInfo;
        this.dateEnd = dateEnd;
        this.technologies = technologies;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
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

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    
}
