package org.codebox.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codebox.entities.compositeIds.LobbyAuthId;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "lobbyauths")
public class LobbyAuth extends PanacheEntityBase {
  @EmbeddedId
  public LobbyAuthId lobbyAuthId;

  @Column(nullable = false)
  public Boolean deleted;
}
