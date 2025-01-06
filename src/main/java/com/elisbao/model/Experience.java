
package com.elisbao.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.time.LocalDate;
import java.util.List;

public class Experience extends PanacheMongoEntity {
    public String company;
    public String position;
    public String description;
    public List<String> technologies;
    public LocalDate dateStart;
    public LocalDate dateEnd;
    public String adicionalInfo;


    public Experience() {
    }

    public Experience(
            String company,
            String position,
            String description,
            LocalDate dateStart,
            String adicionalInfo,
            LocalDate dateEnd,
            List<String> technologies) {
        this.company = company;
        this.position = position;
        this.description = description;
        this.dateStart = dateStart;
        this.adicionalInfo = adicionalInfo;
        this.dateEnd = dateEnd;
        this.technologies = technologies;
    }
}
