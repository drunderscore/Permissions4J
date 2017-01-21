package me.james.permissions4j;

import java.util.logging.*;
import me.james.permissions4j.permission.*;

public abstract class Permissions4J
{
    private static final Logger LOG = Logger.getLogger( "Permissions4J" );

    public static void init()
    {
        Group.createGroup( "default", "Default", null );
        getLogger().info( "Permissions4J initiated." );
    }

    public static Logger getLogger()
    {
        return LOG;
    }

    public static void disableLogging()
    {
        getLogger().setLevel( Level.OFF );
    }

    public enum PermissionValue
    {
        ALLOW, DENY
    }
}
