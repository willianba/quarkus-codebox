package org.codebox.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

import io.vertx.axle.pgclient.PgPool;
import io.vertx.axle.sqlclient.Row;
import io.vertx.axle.sqlclient.RowSet;
import io.vertx.axle.sqlclient.Tuple;

public class CondoResidentDiscussionComment {
  public String id;
  public int residentDiscussionComments;

  public CondoResidentDiscussionComment(String id, int residentDiscussionComments) {
    this.id = id;
    this.residentDiscussionComments = residentDiscussionComments;
  }

  public static CompletionStage<List<CondoResidentDiscussionComment>> findAll(PgPool client) {
    return client.query("SELECT * FROM condos_resident_disc_comments").thenApply(pgRowSet -> {
      List<CondoResidentDiscussionComment> list = new ArrayList<>(pgRowSet.size());
      for (Row row : pgRowSet) {
        list.add(from(row));
      }
      return list;
    });
  }

  public static CompletionStage<CondoResidentDiscussionComment> findById(PgPool client, String id) {
    return client.preparedQuery("SELECT * FROM condos_resident_disc_comments WHERE condo_id = $1", Tuple.of(id))
      .thenApply(RowSet::iterator)
      .thenApply(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
  }

  public static CompletionStage<CondoResidentDiscussionComment> update(PgPool client, CondoResidentDiscussionComment condo) {
    return client.preparedQuery("UPDATE condos_resident_disc_comments SET resident_disc_comments = $1, WHERE condo_id = $2 RETURNING condo_id, resident_disc_comments",
      Tuple.of(condo.residentDiscussionComments, condo.id))
      .thenApply(RowSet::iterator)
      .thenApply(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
  }

  private static CondoResidentDiscussionComment from(Row row) {
    return new CondoResidentDiscussionComment(
      row.getString("condo_id"),
      row.getInteger("resident_disc_comments")
    );
  }
}
