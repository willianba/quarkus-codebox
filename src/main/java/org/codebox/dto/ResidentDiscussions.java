package org.codebox.dto;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class ResidentDiscussions extends PanacheEntity {

    private String id;
    private String condo;
    private String creationDate;
    private String creator;
    private boolean deleted;

    
}