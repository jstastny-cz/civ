#civ-persistence
===============

Project with persistence and DAO, Service, Facade of civ project

**purpose**:

This module is meant to be installed into local Maven repository to be available for other modules to use it. 
	
**requirements**:
* Maven 3 or higher.
* JBoss AS 7.1.1.Final installed with JBOSS_HOME path set properly.
* Tests require the JBoss to be shut down.
	
	
**usage**:

```
	mvn install
```
	
	then the following dependency becomes available to use
	
```xml
	<dependency>
		<groupId>cz.muni.fi.civ</groupId>
		<artifactId>civ-persistence</artifactId>
		<version>...</version>
	</dependency>
```
