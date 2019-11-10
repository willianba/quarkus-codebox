package org.codebox.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codebox.entities.compositeIds.ResidentDiscussionId;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "resident_discussions")
public class ResidentDiscussion extends PanacheEntityBase {
  @EmbeddedId
  public ResidentDiscussionId residentDiscussionId;

  @Column(nullable = false)
  public Boolean deleted;
}
