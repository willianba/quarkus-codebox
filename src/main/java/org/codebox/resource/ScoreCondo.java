package org.codebox.resource;

public class ScoreCondo {
   private int alerts;
   private int trusteediscussions;
   private int lobbyauths;
   private int events;
   private int packages;
   private int logins;
   private int discussions;
   private int discussioncomments;
   private int residentdiscussions;
   private int residentdiscussioncomments;
   private int trusteecomments;


    public ScoreCondo(int alerts, int trusteediscussions, int lobbyauths, int events, int packages,int logins, int discussions,
                      int discussioncomments, int residentdiscussions,int residentdiscussioncomments, int trusteecomments) {
        this.alerts = alerts;
        this.trusteediscussions = trusteediscussions;
        this.lobbyauths = lobbyauths;
        this.events = events;
        this.packages = packages;
        this.logins = logins;
        this.discussions = discussions;
        this.discussioncomments = discussioncomments;
        this.residentdiscussions = residentdiscussions;
        this.residentdiscussioncomments = residentdiscussioncomments;
        this.trusteecomments = trusteecomments;
    }

    public ScoreCondo(String condo_id){
        long alerts = Alerts.count("condo_id", condo_id);
        long trusteediscussions = Condos_trust_comments.find("condo_id", condo_id);
        int lobbyauths = LobbyAuths.count("condo_id", condo_id);
        long events = Condos_events.find("condo_id", condo_id);
        long packages = Packages.count("condo_id", condo_id);
        long logins = Condos_total_login.find("condo_id", condo_id);
        long discussions = Discussions.count("condo_id", condo_id);
        long discussioncomments = Condos_disc_comments.find("condo_id", condo_id);
        long residentdiscussions = ResidentDiscussions.count("condo_id", condo_id);
        long residentdiscussioncomments = Condos_resident_disc_comments.find("condo_id", condo_id);
        long trusteecomments = TrusteeDiscussions.count("condo_id", condo_id);

        ScoreCondo((int) alerts, (int) trusteediscussions, (int) lobbyauths, (int) events, (int) packages,(int) logins, (int) discussions,
                      (int) discussioncomments, (int) residentdiscussions,(int) residentdiscussioncomments, (int) trusteecomments)
    }

    public int getAlerts() {return alerts;}

    public int getTrusteediscussions() {return trusteediscussions;}

    public int getLobbyauths() {return lobbyauths;}

    public int getEvents() {return events;}

    public int getPackages() {return packages;}

    public int getLogins() {return logins;}

    public int getDiscussions() {return discussions;}

    public int getDiscussioncomments() {return discussioncomments;}

    public int getResidentdiscussions() {return residentdiscussions;}

    public int getResidentdiscussioncomments() {return residentdiscussioncomments;}

    public int getTrusteecomments() {return trusteecomments;}


    public int CalculateScore() {
        int score;

        //alerts 10
        //trusteediscussions 8
        //lobbyauths 8
        //events 7
        //packages 7
        //logins 6
        //discussions 4
        //discussioncomments 2
        //residentdiscussions 2
        //residentdiscussioncomments 2
        //trusteecomments 2

        score = (getAlerts() * 10 + getTrusteediscussions() * 8 + getLobbyauths() * 8 + getEvents() * 7 + getPackages() * 7 + getLogins() * 6 +
                getDiscussions() * 4 + getDiscussioncomments() * 2 + getResidentdiscussions() * 2 + getResidentdiscussioncomments() * 2 +
                getTrusteecomments() + 2);

        return score;
    }

    public String ScoreToJson(){
        return "{"score": 1,
        "alerts":1,
        "trusteediscussions": 1,
        "lobbyauths": 1,
        "events": 1,
        "packages": 1,
        "logins": 1,
        "discussions": 1,
        "discussioncomments": 1,
        "residentdiscussions": 1,
        "residentdiscussioncomments": 1,
        "trusteecomments": 1
        }";
}


}