package me.james.permissions4j;

import me.james.permissions4j.permission.*;
import me.james.permissions4j.permission.exceptions.*;

import static me.james.permissions4j.Permissions4J.*;

public class Test
{

    public static void main( String[] args )
    {
        Node.createNode( "dm.send", "Direct Message Send" );
        Node.createNode( "dm.read", "Direct Message Read" );
        Node.createNode( "dm.send.emoji", "Direct Message Send Emoji" );
        Node.createNode( "dm.remove", "Direct Message Remove" );
        Node.createNode( "dm.mute", "Direct Message Mute" );
        Node.createNode( "dm.kick", "Direct Message Kick" );
        Node.createNode( "dm.ban", "Direct Message Ban" );
        Node.createNode( "dm.purge", "Direct Message Bulk Remove" );
        Node.createNode( "dm.permissions", "Direct Message Permissions" );
        try
        {
            Group.createGroup( "user", "User", null ).setNode( Node.getNode( "dm.send" ), PermissionValue.ALLOW ).setNode( Node.getNode( "dm.read" ), PermissionValue.ALLOW );
            Group.createGroup( "member", "Member", Group.getGroup( "user" ) ).setNode( Node.getNode( "dm.send.emoji" ), PermissionValue.ALLOW );
            Group.createGroup( "mod", "Moderator", Group.getGroup( "member" ) ).setNode( Node.getNode( "dm.remove" ), PermissionValue.ALLOW ).setNode( Node.getNode( "dm.mute" ), PermissionValue.ALLOW );
            Group.createGroup( "admin", "Administrator", Group.getGroup( "mod" ) ).setNode( Node.getNode( "dm.kick" ), PermissionValue.ALLOW ).setNode( Node.getNode( "dm.ban" ), PermissionValue.ALLOW ).setNode( Node.getNode( "dm.purge" ), PermissionValue.ALLOW );
            Group.createGroup( "superadmin", "Super Administrator", Group.getGroup( "admin" ) ).setNode( Node.getNode( "dm.permissions" ), PermissionValue.ALLOW );
            Group.createGroup( "operator", "Operator", Group.getGroup( "superadmin" ) );
            Group.createGroup( "muteuser", "Mute User", null ).setNode( Node.getNode( "dm.read" ), PermissionValue.ALLOW );
        } catch ( MissingNodeException e )
        {
            e.printStackTrace();
        }
        User.createUser( "test01", "Test 01", Group.getGroup( "user" ) );
        User.createUser( "test02", "Test 02", Group.getGroup( "user" ) );
        User.createUser( "test03", "Test 03", Group.getGroup( "member" ) );
        User.createUser( "test04", "Test 04", Group.getGroup( "member" ) );
        User.createUser( "test05", "Test 05", Group.getGroup( "member" ) );
        User.createUser( "test06", "Test 06", Group.getGroup( "mod" ) );
        User.createUser( "test07", "Test 07", Group.getGroup( "mod" ) );
        User.createUser( "test08", "Test 08", Group.getGroup( "admin" ) );
        User.createUser( "test09", "Test 09", Group.getGroup( "superadmin" ) );
        User.createUser( "test10", "Test 10", Group.getGroup( "operator" ) );
        User.createUser( "test11", "Test 11", Group.getGroup( "muteuser" ) );
        User.createUser( "test12", "Test 12", Group.getGroup( "muteuser" ) );
        Permissions4J.disableLogging();
        Permissions4J.init();
        try
        {
            System.out.println( String.format( "%s %s %s", User.getUser( "test01" ).hasPermission( Node.getNode( "dm.send" ) ), User.getUser( "test11" ).hasPermission( Node.getNode( "dm.send" ) ), User.getUser( "test08" ).hasPermission( Node.getNode( "dm.purge" ) )) );
        } catch ( MissingNodeException e )
        {
            e.printStackTrace();
        }
    }
}
