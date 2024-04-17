package IssueResolution.Service;

import IssueResolution.utils.IssueStatus;
import IssueResolution.utils.IssueType;
import IssueResolution.utils.Exceptions.IssueNotFoundException;
import IssueResolution.utils.Exceptions.NoAgentFoundException;

import java.util.List;

public interface IssueService {
    // sout ex "Issue I1 created against transaction "T1"
    public void createIssue(String transactionId,String issueType,String subject,String description,String email);
    public void addAgent(String agentEmail, String agentName , List<IssueType> issuesList);

    public void assignIssue(String issueId) throws IssueNotFoundException, NoAgentFoundException;

    public void getIssues(String filter);

    public void updateIssue(String issueId,IssueStatus  status,String resolution);


    public void  resolveIssue(String issueId, String resolution);
     public void viewAgentsWorkHistory();

}
