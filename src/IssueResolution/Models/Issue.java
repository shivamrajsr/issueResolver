package IssueResolution.Models;

import IssueResolution.utils.IssueStatus;
import IssueResolution.utils.IssueType;

public class Issue {
    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "transactionId='" + transactionId + '\'' +
                ", issueType=" + issueType +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", resolved=" + resolved +
                '}';
    }

    //transactionId, issueType, subject, description, email
    private String transactionId;
    private IssueType issueType;
    private String subject;
    private String description;
    private String email;

    private IssueStatus resolved;

    public Issue(String transactionId, IssueType issueType, String subject, String description, String email) {
        this.transactionId = transactionId;
        this.issueType = issueType;
        this.subject = subject;
        this.description = description;
        this.email = email;
        this.resolved = IssueStatus.PENDING;
    }

    public IssueType getIssueType() {
        return issueType;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IssueStatus isResolved() {
        return resolved;
    }

    public boolean setResolved(IssueStatus resolved) {
        this.resolved = resolved;
        System.out.println("Issue "+ transactionId +" marked resolved");
        return true;
    }

}
