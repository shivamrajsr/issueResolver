import IssueResolution.utils.Exceptions.IssueNotFoundException;
import IssueResolution.utils.Exceptions.NoAgentFoundException;
import IssueResolution.utils.IssueType;
import IssueResolution.Service.IssueServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IssueNotFoundException, NoAgentFoundException {


        IssueServiceImpl service = new IssueServiceImpl();
       // IssueServiceImpl service2 = new IssueServiceImpl();



        service.createIssue("T1", "PAYMENT", "Payment Failed", "My payment failed but money is debited",
                "test@gmail.com");
        service.createIssue("T2", "PAYMENT", "Payment Failed", "unable to purchase mutual fund",
                "test@gmail.com");
        service.createIssue("T3", "MUTUAL_FUND", "Purchase Failed", "My payment failed but money is debited",
                "test@gmail.com");
        service.addAgent("agent@binod.com","binod", Arrays.asList(IssueType.PAYMENT, IssueType.MUTUAL_FUND));
        service.assignIssue("T1");

        service.getIssues("test@gmail.com");
        service.resolveIssue("T3", "PaymentFailed debited amount will get reversed");

    }
}