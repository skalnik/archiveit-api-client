package lu.bnl.archiveit.client.exceptions;


public class HttpRequestFailedException extends Exception 
{ 
    public HttpRequestFailedException(String errorMessage) 
    {
        super(errorMessage);
    }
}
