package org.codebox.dto;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Events extends PanacheEntity {

    public String id;
    public String condo_id;
    public int events;

    public static int findByCondo_id(String id){
        return find("condo_id", id).firstResult().events;
    }
   
}