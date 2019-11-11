package org.codebox.resources;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codebox.ScoreCalculator;
import org.codebox.entities.Condo;

import io.quarkus.panache.common.Sort;

@Path("score")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScoreResource {
  @Inject
  private ScoreCalculator scoreCalculator;

  @GET
  public List<Condo> get() {
    // TODO: should calculate score
    return Condo.listAll(Sort.by("name"));
  }
}
