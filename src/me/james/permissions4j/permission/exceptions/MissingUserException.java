package me.james.permissions4j.permission.exceptions;

public class MissingUserException extends Exception
{
    private String id;

    public MissingUserException( String id )
    {
        this.id = id;
    }

    public String getMissingID()
    {
        return id;
    }
}
