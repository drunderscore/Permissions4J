package me.james.permissions4j.permission;

import com.sun.istack.internal.*;
import java.util.*;
import me.james.permissions4j.*;
import me.james.permissions4j.permission.exceptions.*;

public class Node
{
    private static HashMap<String, Node> nodes = new HashMap<>();
    private String permission, name;

    private Node( String permission, String name )
    {
        this.permission = permission;
        this.name = name;
    }

    public static Node createNode( @NotNull String node, @NotNull String name )
    {
        Node n = new Node( node, name );
        nodes.put( node, n );
        for ( Group g : Group.getGroups() )
        {
            if ( g.getInherit() == null )
                g.setNode( n, Permissions4J.PermissionValue.DENY );
            else
                g.setNode( n, null );
        }
        return n;
    }

    public static Node[] getNodes()
    {
        return nodes.values().toArray( new Node[nodes.values().size()] );
    }

    public static Node getNode( String permission ) throws MissingNodeException
    {
        if ( !nodes.containsKey( permission ) )
            throw new MissingNodeException( permission );
        return nodes.get( permission );
    }

    public String getPermission()
    {
        return permission;
    }

    public String getName()
    {
        return name;
    }
}
