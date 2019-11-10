package org.codebox.entities.compositeIds;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DiscussionId implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(nullable = false, name = "condo_id")
  private String condoId;

  @Column(nullable = false, name = "creation_date")
  private Timestamp creationDate;

  @Column(nullable = false, name = "first_creator")
  private String firstCreator;

  @Column(nullable = false, name = "second_creator")
  private String secondCreator;
}
