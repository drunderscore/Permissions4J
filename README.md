# Permissions4J
A permission system for Java

## What can Permissions4J do?
**Permissiononize!**

Permissions4J supports the following as of the most recent release:
* Groups
  * with inheritable permissions
* Users
  * limited to single-groups as of most recent release.
* Permission Nodes
* **All** of these have IDs and display names attached to them!

## How do I use it?
**Simply!**

[Full Example](../master/src/me/james/permissions4j/Example.java)

To start off, call `Permissions4J#init` to initialize the permission system.

Although this call initializes very few things in the current release, it may be utilized for future releases and should be kept in code to stay updated.

Use `Node#createNode` to create a permission node with an ID and display.

Use `Group#createGroup` to create a group with an ID and display.

Use `User#createUser` to create a user with an ID and display.

## Anything else?
**Nope...**

This is pretty much it. Although a small library, a helpful one when developing things that require Users to have specific permissions that can be cusomizable between things such as servers by server owners.
