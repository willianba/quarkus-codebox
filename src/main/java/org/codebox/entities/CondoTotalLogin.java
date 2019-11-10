package org.codebox.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "condos_total_login")
public class CondoTotalLogin extends PanacheEntityBase {
  @Id
  @Column(name = "condo_id")
  public String condoId;

  @Column(nullable = false, name = "total_logins")
  public int totalLogins;
}
