package org.codebox.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "condos")
public class Condo extends PanacheEntityBase {
  @Id
  @Column(name = "condo_id")
  private String condoId;

  @Column(nullable = false)
  public String name;

  @Column(nullable = false)
  public Boolean deleted;

  public String getId() {
    return condoId;
  }

  @Override
  public String toString() {
    return "Name: " + name + " Id: " + condoId + " deleted: " + deleted;
  }
}
