package org.codebox.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

import io.vertx.axle.pgclient.PgPool;
import io.vertx.axle.sqlclient.Row;
import io.vertx.axle.sqlclient.RowSet;
import io.vertx.axle.sqlclient.Tuple;

public class CondoEvent {
  public String id;
  public int events;

  public CondoEvent(String id, int events) {
    this.id = id;
    this.events = events;
  }

  public static CompletionStage<List<CondoEvent>> findAll(PgPool client) {
    return client.query("SELECT * FROM condos_events").thenApply(pgRowSet -> {
      List<CondoEvent> list = new ArrayList<>(pgRowSet.size());
      for (Row row : pgRowSet) {
        list.add(from(row));
      }
      return list;
    });
  }

  public static CompletionStage<CondoEvent> findById(PgPool client, String id) {
    return client.preparedQuery("SELECT * FROM condos_events WHERE condo_id = $1", Tuple.of(id))
      .thenApply(RowSet::iterator)
      .thenApply(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
  }

  public static CompletionStage<CondoEvent> update(PgPool client, CondoEvent condoEvent) {
    return client.preparedQuery("UPDATE condos_events SET events = $1 WHERE condo_id = $2 RETURNING condo_id, events",
      Tuple.of(condoEvent.events, condoEvent.id))
      .thenApply(RowSet::iterator)
      .thenApply(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
  }

  private static CondoEvent from(Row row) {
    return new CondoEvent(
      row.getString("condo_id"),
      row.getInteger("events")
    );
  }
}
