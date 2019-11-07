package org.codebox.dto;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class LobbyAuths extends PanacheEntity {

    public String id;
    public String condo;
    public String creationDate;
    public String creator;
    public boolean deleted;
    public String authFromDate;

    
}