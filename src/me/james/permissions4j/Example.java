package me.james.permissions4j;

import me.james.permissions4j.permission.*;
import me.james.permissions4j.permission.exceptions.*;

public class Example
{

    public static void main( String[] args )
    {
        //Recommended that you create all your Node(s) in one place.
        Node.createNode( "dm.send", "Direct Message Send" );
        Node.createNode( "dm.read", "Direct Message Read" );
        Node.createNode( "dm.purge", "Direct Message Purge (Bulk Delete)" );
        Node.createNode( "dm.delete", "Direct Message Delete" );
        Node.createNode( "dm.mute", "Direct Message Mute" );
        Permissions4J.disableLogging(); //Nasty stuff.
        Permissions4J.init();
        try
        {
            //Group#setNode can be used like a builder!
            Group.createGroup( "members", "Members", null ).setNode( Node.getNode( "dm.send" ), Permissions4J.PermissionValue.ALLOW ).setNode( Node.getNode( "dm.read" ), Permissions4J.PermissionValue.ALLOW );
            //Semi-decent inheritable group system.
            Group.createGroup( "mod", "Moderators", Group.getGroup( "members" ) ).setNode( Node.getNode( "dm.delete" ), Permissions4J.PermissionValue.ALLOW ).setNode( Node.getNode( "dm.mute" ), Permissions4J.PermissionValue.ALLOW );
            //Sadly, Users only support a single group. Implementation will go with multiple groups and a group hierarchy.
            User.createUser( "user01", "User 01", Group.getGroup( "members" ) );
            User.createUser( "user02", "User 02", Group.getGroup( "members" ) );
            User.createUser( "user03", "User 03", Group.getGroup( "members" ) );
            User.createUser( "user04", "User 04", Group.getGroup( "members" ) );
            User.createUser( "user05", "User 05", Group.getGroup( "members" ) );
            User.createUser( "user06", "User 06", Group.getGroup( "members" ) );
            User.createUser( "user07", "User 07", Group.getGroup( "mod" ) );
            User.createUser( "user08", "User 08", Group.getGroup( "mod" ) );
            System.out.println( User.getUser( "user01" ).hasPermission( Node.getNode( "dm.send" ) ) + ", " + User.getUser( "user07" ).hasPermission( Node.getNode( "dm.delete" ) ) + ", " + User.getUser( "user04" ).hasPermission( Node.getNode( "dm.delete" ) ) + ", " + User.getUser( "user08" ).hasPermission( Node.getNode( "dm.purge" ) ) );
        } catch ( MissingNodeException | MissingGroupException | MissingUserException e )
        {
            e.printStackTrace();
        }
    }
}
