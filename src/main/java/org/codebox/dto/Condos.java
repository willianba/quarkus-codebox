package org.codebox.dto;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Condos extends PanacheEntity{

    public String id;
    public String name;
    public boolean deleted;
    
}