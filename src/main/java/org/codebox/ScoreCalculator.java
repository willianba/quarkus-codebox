package org.codebox;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.codebox.entities.*;

@ApplicationScoped
public class ScoreCalculator {
  public void calculateScoreForAllCondos() {
    List<Condo> condos = Condo.listAll();
    for (Condo condo : condos) {
    }
  }

  public double calculateScore(int alerts, int dComment, int discussion, int condoEvent, int lAuth, int logins,
      int rDiscussion, int cComment, int trusteeDiscussion, int cTrusteeComment, int package1) {

    double score = (10.0 * alerts) + (2.0 * (dComment + cComment + cTrusteeComment))
        + (4.0 * (discussion + lAuth + package1)
            + (8.0 * (rDiscussion + trusteeDiscussion) + (6.0 * logins) + (7.0 * condoEvent)));
    return score;
  }

  public static double setToRange(double x) {
    return (((x - 0) * (100 - 0)) / (50000 - 0)) + 0;
  }
}
/*
 * public void calculateScore(Alert alerts, CondosDiscussionComment dComment,
 * Discussion discussion, CondoEvent condoEvent, LobbyAuth lAuth,
 * CondoTotalLogin logins, ResidentDiscussion rDiscussion,
 * CondoResidentDiscussionComment cComment, TrusteeDiscussion trusteeDiscussion,
 * CondoTrusteeComment cTrusteeComment, Package package1)
 */
/*
 * Circulares - 10 Comentário em fórum - 2 Tópicos - 4 Reservas - 7 Autorização
 * de entrada - 4 Logins - 6 Mensagens - 8 Comentário de Mensagens - 2 Chamados
 * - 8 Comentários de chamados - 2 Entregas - 4
 */
