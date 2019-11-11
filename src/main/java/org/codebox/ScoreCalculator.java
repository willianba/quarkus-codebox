package org.codebox;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.codebox.entities.Condo;

@ApplicationScoped
public class ScoreCalculator {
  public void calculateScoreForAllCondos() {
    List<Condo> condos = Condo.listAll();
    for (Condo condo : condos) {
    }
  }
}
