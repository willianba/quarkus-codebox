package org.codebox.dto;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Condos extends PanacheEntity{

    private String id;
    private String name;
    private boolean deleted;
    
}