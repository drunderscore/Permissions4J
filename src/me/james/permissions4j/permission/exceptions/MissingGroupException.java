package me.james.permissions4j.permission.exceptions;

public class MissingGroupException extends Exception
{
    private String id;

    public MissingGroupException( String id )
    {
        this.id = id;
    }
    
    public String getMissingID()
    {
        return id;
    }
}
