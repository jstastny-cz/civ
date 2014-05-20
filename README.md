civ
===

This project serves as a showcase application of Drools 6.0 and jBPM 6.0. Its main purpose was to find out whether the tools offer sufficient functionality for game-logic implementation of turn-based strategic computer game.

**Modules**

Whole civ project consists of five modules:
* civ-persistence-api
* civ-persistence
* civ-kie
* civ-game
* civ-rest

In this README I won't go into any further details about the modules, please refer to README files of corresponding modules.

**Requirements**
* Java 7 with JAVA_HOME system variable set properly
* JBOSS AS 7.1.1.Final with JBOSS_HOME system variable set properly

For further information on used technologies and their versions please refer to README files of defined modules and their pom files.

* Chosen aspects of game-logic were implemented and tested by unit tests in civ-kie module.
* Game component managing all game actions and user interactions is defined in civ-game module.
* Upon the afore mentioned modules the civ-rest module builds a RESTful API to demonstrate functionality.
* The civ-persistence and civ-persistence-api modules define persistent storage for entities of game world.

Recommended usage: run mvn install from civ folder to install all modules and deploy rest application to JBOSS AS. The server has to be already running.

For testing the implementaion through its rest api, refer to file testData.txt placed in root folder of civ-rest module. Further information on how use these data is present in the file itself.
