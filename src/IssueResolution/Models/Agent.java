package IssueResolution.Models;

import IssueResolution.utils.IssueStatus;
import IssueResolution.utils.IssueType;

import java.util.ArrayList;
import java.util.List;

public class Agent {

   // agentEmail, agentName ,List<issueType>

    private String agentEmail;
    private String agentName;

    private List<IssueType> expertise;

    private List<Issue> assignedIssues;

    private List<Issue> history;

    public List<Issue> getHistory() {
        return history;
    }

    public Agent(String agentEmail, String agentName, List<IssueType> expertise) {
        this.agentEmail = agentEmail;
        this.agentName = agentName;
        this.expertise =  expertise;
        this.assignedIssues = new ArrayList<>();
    }

    public String getAgentEmail() {
        return agentEmail;
    }
    public List<IssueType> getExpertise() {
        return expertise;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void assignIssue(Issue issue) {
        assignedIssues.add(issue);
    }

    // Method to resolve an issue
    public void resolveIssue(Issue issue, String resolution) {
        issue.setResolved(IssueStatus.RESOLVED);
        assignedIssues.remove(issue);
        history.add(issue);
    }



    public List<Issue> getAssignedIssues() {
        return assignedIssues;
    }

}
