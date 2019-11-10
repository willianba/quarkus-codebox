package org.codebox.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codebox.entities.compositeIds.AlertId;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "alerts")
public class Alert extends PanacheEntityBase {
  @EmbeddedId
  public AlertId alertsId;

  @Column(nullable = false)
  public Boolean deleted;
}
