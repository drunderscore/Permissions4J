package me.james.permissions4j.permission;

import com.sun.istack.internal.*;
import java.util.*;
import me.james.permissions4j.permission.exceptions.*;

public class User
{
    private static HashMap<String, User> users = new HashMap<>();
    private String id, name;
    //    private HashMap<String, Group> groups = new HashMap<>(); //TODO: Multiple groups! Hierarchy support!
    private Group group;

    private User( String id, String name, Group g )
    {
        this.id = id;
        this.name = name;
        this.group = g;
    }

    public static User createUser( @NotNull String id, @NotNull String name, @NotNull Group g )
    {
        User u = new User( id, name, g );
        users.put( id, u );
        return u;
    }

    public static User[] getUsers()
    {
        return users.values().toArray( new User[users.values().size()] );
    }

    public static User getUser( String id ) throws MissingUserException
    {
        if ( !users.containsKey( id ) )
            throw new MissingUserException( id );
        return users.get( id );
    }

    public String getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public boolean hasPermission( Node n )
    {
        return group.hasPermission( n );
    }
}
