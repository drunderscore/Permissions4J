package me.james.permissions4j.permission.exceptions;

public class MissingNodeException extends Exception
{
    private String perm;
    
    public MissingNodeException(String perm)
    {
        this.perm = perm;
    }

    public String getMissingPermission()
    {
        return perm;
    }
}
