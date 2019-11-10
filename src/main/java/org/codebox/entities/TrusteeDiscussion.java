package org.codebox.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codebox.entities.compositeIds.TrusteeDiscussionId;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "trustee_discussions")
public class TrusteeDiscussion extends PanacheEntityBase {
  @EmbeddedId
  public TrusteeDiscussionId trusteeDiscussionId;

  @Column(nullable = false)
  public Boolean deleted;
}
