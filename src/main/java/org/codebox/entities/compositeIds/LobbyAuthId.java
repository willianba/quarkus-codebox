package org.codebox.entities.compositeIds;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LobbyAuthId implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(nullable = false, name = "condo_id")
  private String condoId;

  @Column(nullable = false, name = "creation_date")
  private Timestamp creationDate;

  @Column(nullable = false)
  private String creator;

  @Column(nullable = false, name = "auth_from_date")
  private Timestamp authFromDate;
}