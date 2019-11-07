package org.codebox.dto;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class DiscussionComments extends PanacheEntity {

    private String id;      
    private String condo_id;;
    private int disc_comments;

    public static int findByCondo_id(String id){
        return find("condo_id", id).firstResult().disc_comments;
    }
        
}