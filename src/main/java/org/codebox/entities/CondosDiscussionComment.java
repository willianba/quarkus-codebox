package org.codebox.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

import io.vertx.axle.pgclient.PgPool;
import io.vertx.axle.sqlclient.Row;
import io.vertx.axle.sqlclient.RowSet;
import io.vertx.axle.sqlclient.Tuple;

public class CondosDiscussionComment {
  public String id;
  public int discussionComments;

  public CondosDiscussionComment(String id, int discussionComments) {
    this.id = id;
    this.discussionComments = discussionComments;
  }

  public static CompletionStage<List<CondosDiscussionComment>> findAll(PgPool client) {
    return client.query("SELECT * FROM condos_disc_comments").thenApply(pgRowSet -> {
      List<CondosDiscussionComment> list = new ArrayList<>(pgRowSet.size());
      for (Row row : pgRowSet) {
        list.add(from(row));
      }
      return list;
    });
  }

  public static CompletionStage<CondosDiscussionComment> findById(PgPool client, String id) {
    return client.preparedQuery("SELECT * FROM condos_disc_comments WHERE condo_id = $1", Tuple.of(id))
      .thenApply(RowSet::iterator)
      .thenApply(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
  }

  public static CompletionStage<CondosDiscussionComment> update(PgPool client, CondosDiscussionComment condo) {
    return client.preparedQuery("UPDATE condos_disc_comments SET discussion_comments = $1, WHERE condo_id = $2 RETURNING condo_id, discussion_comments",
      Tuple.of(condo.discussionComments, condo.id))
      .thenApply(RowSet::iterator)
      .thenApply(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
  }

  private static CondosDiscussionComment from(Row row) {
    return new CondosDiscussionComment(
      row.getString("condo_id"),
      row.getInteger("discussion_comments")
    );
  }
}
