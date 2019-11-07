package org.codebox.dto;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Alerts extends PanacheEntity {

    private String id;
    private String condo_id;
    private String creationDate;
    private String creator;
    private boolean deleted;


    public static int countById(String id){
        return null;
    }
}