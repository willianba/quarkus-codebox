package org.codebox.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codebox.entities.compositeIds.PackageId;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "packages")
public class Package extends PanacheEntityBase {
  @EmbeddedId
  public PackageId packageId;

  @Column(nullable = false)
  public Boolean deleted;
}
