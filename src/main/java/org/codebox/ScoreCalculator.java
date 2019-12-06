package org.codebox;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.codebox.entities.*;
import org.codebox.entities.Package;

@Path("/score")
@ApplicationScoped
public class ScoreCalculator {

  public void calculateScoreForAllCondos() {
    List<Condo> condos = Condo.listAll();
    for (Condo condo : condos) {
      List<Alert> alerts = getAlertsForCondo(condo.getId());
      List<Discussion> discussions = getDiscussionsForCondo(condo.getId());
      List<ResidentDiscussion> residisc = getResidentDiscussionsForCondo(condo.getId());
      List<TrusteeDiscussion> trusteedisc = getTrusteeDiscussionsForCondo(condo.getId());
      List<Package> packages = getPackagesForCondo(condo.getId());
      List<LobbyAuth> lobbyAuths = getLobbyAuthsForCondo(condo.getId());

    }
  }

  @Path("/condos")
  @GET
  public String condosnames() {
    List<Condo> condos = Condo.listAll();
    String condosNames = "";
    for (Condo condo : condos) {
      condosNames.concat(" " + condo.name);
    }
    return condosNames;
  }

  @Path("/alerts")
  @GET
  public Long numberOfAlerts() {
    return Alert.count();
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

  public List<Alert> getAlertsForCondo(String condo_id) {
    return null;
  }

  public List<Discussion> getDiscussionsForCondo(String condo_id) {
    return null;
  }

  public List<ResidentDiscussion> getResidentDiscussionsForCondo(String condo_id) {
    return null;
  }

  public List<TrusteeDiscussion> getTrusteeDiscussionsForCondo(String condo_id) {
    return null;
  }

  public List<Package> getPackagesForCondo(String condo_id) {
    return null;
  }

  public List<LobbyAuth> getLobbyAuthsForCondo(String condo_id) {
    return null;
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
