# TICTACTOE JAVA CLI

This is a JAVA COMMAND LINE INTERFACE app to play TICTACTOE

It is made using simple maven project and follows its architecture

It has two modes, two player and vs computer modes

VsComputer mode has self made AI algorithm which minimizes the chances for opponent's win

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `pom.xml`: the file to maintain maven dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

The entry point of this app is :
>src/main/java/tictactoe/App.java
## Version history


0.1 - First instance of app ready for production stage

1.0 - Changed the whole structure and used the concept of oops

2.0 - Converted into maven project and included a mysql database


## Database
Used mysql running on local machine.

It has two tables:

* vs_others - records the score of a player against other players.
* vs_computer - records the score of a player against computer


## Dependency Management

Dependencies are managed using maven.

The only dependency currently being used is of mysql8.0.27

``` 
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.27</version>
</dependency>
 ```