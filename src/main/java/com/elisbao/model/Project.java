package com.elisbao.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

public class Project extends PanacheMongoEntity {
    private ObjectId id;
    private String name;
    private String description;
    private List<String> technologies;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String linkRepository;
    private String linkDemo;
    private String additionalInfo;

    public Project() {
    }

    public Project(
            String name,
            List<String> technologies,
            LocalDate dateStart,
            String description,
            LocalDate dateEnd,
            String additionalInfo,
            String linkDemo,
            String linkRepository) {
        this.name = name;
        this.technologies = technologies;
        this.dateStart = dateStart;
        this.description = description;
        this.dateEnd = dateEnd;
        this.additionalInfo = additionalInfo;
        this.linkDemo = linkDemo;
        this.linkRepository = linkRepository;
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

    public String getLinkRepository() {
        return linkRepository;
    }

    public void setLinkRepository(String linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String getLinkDemo() {
        return linkDemo;
    }

    public void setLinkDemo(String linkDemo) {
        this.linkDemo = linkDemo;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
