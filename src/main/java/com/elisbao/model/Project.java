package com.elisbao.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.time.LocalDate;
import java.util.List;

public class Project extends PanacheMongoEntity {
    public String name;
    public String description;
    public List<String> tecnologies;
    public LocalDate dateStart;
    public LocalDate dateEnd;
    public String link_repository;
    public String link_demo;
    public String adicionalInfo;

    public Project() {
    }

    public Project(
            String name,
            List<String> tecnologies,
            LocalDate dateStart,
            String description,
            LocalDate dateEnd,
            String adicionalInfo,
            String link_demo,
            String link_repository) {
        this.name = name;
        this.tecnologies = tecnologies;
        this.dateStart = dateStart;
        this.description = description;
        this.dateEnd = dateEnd;
        this.adicionalInfo = adicionalInfo;
        this.link_demo = link_demo;
        this.link_repository = link_repository;
    }
}
