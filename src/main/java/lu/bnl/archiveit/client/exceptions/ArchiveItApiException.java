package lu.bnl.archiveit.client.exceptions;


public class ArchiveItApiException extends Exception 
{ 
    public ArchiveItApiException(String errorMessage) 
    {
        super(errorMessage);
    }
}
