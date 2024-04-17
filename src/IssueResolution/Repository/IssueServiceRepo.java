package IssueResolution.Repository;

import IssueResolution.Models.Agent;
import IssueResolution.Models.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IssueServiceRepo {
    private List<Issue> issuesList;

    private List<Agent> agentList ;

    private static volatile IssueServiceRepo instance;

    private IssueServiceRepo() {
        this.issuesList = new ArrayList<>();
        this.agentList = new ArrayList<>();
    }

    public static IssueServiceRepo getInstance() {
        IssueServiceRepo result = instance;
        if (result == null) {
            synchronized (IssueServiceRepo.class) {
                result = instance;
                if (result == null) {
                    instance = result = new IssueServiceRepo();
                }
            }
        }
        else {
            System.out.println("IssueServiceRepo is already initialized.");
        }
        return result;
    }

   public Issue getIssueById(String transactionId){
       for (Issue issue : issuesList) {
           if (issue.getTransactionId().equalsIgnoreCase(transactionId)) {
               return issue;
           }
       }
       return null;

   }
    public List<Issue> getIssuesList() {
        return issuesList;
    }

    public void setIssuesList(List<Issue> issuesList) {
        this.issuesList = issuesList;
    }

    public List<Agent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
    }


}
