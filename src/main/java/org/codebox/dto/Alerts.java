package org.codebox.dto;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Alerts extends PanacheEntity {

    public String id;
    public String condo_id;
    public String creationDate;
    public String creator;
    public boolean deleted;

}