package org.codebox.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codebox.entities.compositeIds.DiscussionId;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "discussions")
public class Discussion extends PanacheEntityBase {
  @EmbeddedId
  public DiscussionId discussionId;

  @Column(nullable = false)
  public Boolean deleted;
}
