package tictactoecli.params;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import tictactoecli.board.Player_Scores;


public class DBParams {

    public static final String DB_URL="jdbc:mysql://localhost:3306/";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="1234";

    public static final String DB_NAME="tictactoe_scores";
    public static final String OTHERS_TABLE="vs_others";
    public static final String COMPUTER_TABLE="vs_computer";
    
    public static Connection connection;
    public static Statement statement; 
    public static ResultSet result;

    public static void onCreate() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(DB_URL, DB_USER , DB_PASSWORD);   
            statement=connection.createStatement();
            // connect();
            create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void create(){
        createDatabase();
        createVSOthers();
        createVSComputer();

    }

    private static void createDatabase() {
        try {
            boolean b=statement.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
            b=statement.execute("USE "+DB_NAME+";");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createVSOthers() {
        try {
            boolean b=statement.execute("CREATE TABLE IF NOT EXISTS "+OTHERS_TABLE+" (id          INT UNSIGNED NOT NULL PRIMARY KEY  AUTO_INCREMENT,player_name VARCHAR(20) NOT NULL,total_games INT UNSIGNED NOT NULL,won         INT UNSIGNED NOT NULL,lost        INT UNSIGNED NOT NULL,draw        INT UNSIGNED NOT NULL);");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createVSComputer() {
        try {
            boolean b=statement.execute("CREATE TABLE IF NOT EXISTS "+COMPUTER_TABLE+" (id          INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,player_name VARCHAR(20) NOT NULL,total_games INT UNSIGNED NOT NULL,won         INT UNSIGNED NOT NULL,lost        INT UNSIGNED NOT NULL,draw        INT UNSIGNED NOT NULL);");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //checks if plyer is in database or not, if he is not add player to database and set everything to 0
    public static void checkPlayer(String player_name,String table_name) {
        try {
            result=statement.executeQuery("SELECT id FROM "+table_name+" where player_name='"+player_name+"';");
            if(!result.next()){
                int updates = statement.executeUpdate("INSERT INTO "+table_name+" (player_name,total_games,won,lost,draw) values ('"+player_name+"',0,0,0,0);");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // updates score of the player acc to result
    // 1 for win
    // 0 for draw
    // -1 for lost
    public static void updateScore(String player_name,String table_name,int result) {
        try {
            String query="UPDATE "+table_name+" SET total_games=total_games+1,";
            if (result==1) {
                query+="won=won+1 ";
            }
            else if (result==0) {
                query+="draw=draw+1";
            }
            else {
                query+="lost=lost+1";
            }
            query+=" where player_name='"+player_name+"';";

            int update=statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static Player_Scores getScores(String player_name,String table_name) {
        checkPlayer(player_name, table_name);
        Player_Scores score = new Player_Scores(player_name,0,0,0,0);
        try {
            result=statement.executeQuery("SELECT * FROM "+table_name+" WHERE player_name='"+player_name+"';");
            result.next();
            score=new Player_Scores(result.getString(2), result.getInt(3), result.getInt(4), result.getInt(5), result.getInt(6));
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        return score;
    }

    
}
