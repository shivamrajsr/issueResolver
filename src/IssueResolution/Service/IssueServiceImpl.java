package IssueResolution.Service;

import IssueResolution.utils.IssueStatus;
import IssueResolution.utils.IssueType;
import IssueResolution.Models.Agent;
import IssueResolution.Models.Issue;
import IssueResolution.Repository.IssueServiceRepo;
import IssueResolution.utils.Exceptions.IssueNotFoundException;
import IssueResolution.utils.Exceptions.NoAgentFoundException;

import java.util.List;

public class IssueServiceImpl implements  IssueService{

    private IssueServiceRepo repository;

    //compo
    public IssueServiceImpl() {
        this.repository = IssueServiceRepo.getInstance();
    }

    @Override
    public void createIssue(String transactionId, String issueType, String subject, String description, String email) {
        System.out.println(IssueType.valueOf(issueType));
        Issue issue = new Issue(transactionId, IssueType.valueOf(issueType), subject, description, email);
        repository.getIssuesList().add(issue);
        System.out.println(STR."Issuecreated against transactionId \{transactionId}");

    }

    @Override
    public void addAgent(String agentEmail, String agentName, List<IssueType> expertise) {
        Agent agent = new Agent(agentEmail, agentName, expertise);
        repository.getAgentList().add(agent);
        System.out.println(STR."agent with name \{agentName} created");

    }
   // we take issueId as the transactionId
    @Override
    public void assignIssue(String issueId) throws IssueNotFoundException, NoAgentFoundException {

         Issue issue = repository.getIssueById(issueId);
         if(issue==null) {
             throw new IssueNotFoundException("Issue Doesnt exist");
         }
        //logic to find the free agent and assign the ticket
        Agent agent = findAgent();
        if (agent != null) {
            agent.assignIssue(issue);
            System.out.println(STR."issue \{issueId} assgined to agent \{agent.getAgentName()}");
        }
        else
            throw new NoAgentFoundException();

    }
    private Agent findAgent() throws NoAgentFoundException {
        for (Agent agent : repository.getAgentList()) {
            if(agent.getAssignedIssues().isEmpty()){
                return agent;
            }
        }
        throw new NoAgentFoundException();
    }

    public Agent findFreeAgent(IssueType issueType) {
        for (Agent agent : repository.getAgentList()) {
            if (agent.getAssignedIssues().isEmpty() && agent.getExpertise().contains(issueType)) {
                return agent;
            }
        }
        return null;
    }

    @Override
    public void getIssues(String filter) {
        for (Issue issue : repository.getIssuesList()) {
            if (filter.equalsIgnoreCase(issue.getIssueType().toString()) ||
                    filter.equalsIgnoreCase(issue.isResolved().toString()) ||
                    filter.equalsIgnoreCase(issue.getEmail().toString())) {
                System.out.println(issue.toString());
            }
        }
    }


    @Override
    public void updateIssue(String issueId, IssueStatus status, String resolution) {
        Issue issue = repository.getIssueById(issueId);
        if (issue != null) {
            issue.setResolved(status);
        }

    }

    @Override
    public void resolveIssue(String issueId, String resolution) {
        Issue issue = repository.getIssueById(issueId);
        if (issue != null) {
            issue.setResolved(IssueStatus.RESOLVED);
        }
    }

    @Override
    public void viewAgentsWorkHistory() {
        // just have to convert to string
        for(Agent agent : repository.getAgentList()){
            System.out.println(STR."\{agent.getAgentName()}\{agent.getHistory().toString()}"
            );
        }
    }
}
