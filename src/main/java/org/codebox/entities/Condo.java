package org.codebox.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

import io.vertx.axle.pgclient.PgPool;
import io.vertx.axle.sqlclient.Row;
import io.vertx.axle.sqlclient.RowSet;
import io.vertx.axle.sqlclient.Tuple;

public class Condo {
  public String id;
  public String name;
  public Boolean deleted;

  public Condo(String id, String name, boolean deleted) {
    this.id = id;
    this.name = name;
    this.deleted = deleted;
  }

  public static CompletionStage<List<Condo>> findAll(PgPool client) {
    return client.query("SELECT * FROM condos").thenApply(pgRowSet -> {
      List<Condo> list = new ArrayList<>(pgRowSet.size());
      for (Row row : pgRowSet) {
        list.add(from(row));
      }
      return list;
    });
  }

  public static CompletionStage<Condo> findById(PgPool client, String id) {
    return client.preparedQuery("SELECT * FROM condos WHERE condo_id = $1", Tuple.of(id))
      .thenApply(RowSet::iterator)
      .thenApply(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
  }

  public static CompletionStage<Condo> update(PgPool client, Condo condo) {
    return client.preparedQuery("UPDATE condos SET name = $1, deleted = $2 WHERE condo_id = $3 RETURNING condo_id, name, deleted",
      Tuple.of(condo.name, condo.deleted, condo.id))
      .thenApply(RowSet::iterator)
      .thenApply(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
  }

  private static Condo from(Row row) {
    return new Condo(
      row.getString("condo_id"),
      row.getString("name"),
      row.getBoolean("deleted")
    );
  }
}
