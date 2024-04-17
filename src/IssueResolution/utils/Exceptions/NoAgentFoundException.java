package IssueResolution.utils.Exceptions;

import IssueResolution.utils.Constants.Constants;

public class NoAgentFoundException extends Exception{
    public NoAgentFoundException(){
        super(Constants.NoAgentException);
    }
}
