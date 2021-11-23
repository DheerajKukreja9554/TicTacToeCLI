package tictactoecli.board;

import tictactoecli.params.DBParams;

public class Player {
    public String name;
    public char symbol;
    public Player_Scores others_scores;
    public Player_Scores computer_scores;
    
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        others_scores=DBParams.getScores(name,DBParams.OTHERS_TABLE);
        computer_scores=DBParams.getScores(name,DBParams.COMPUTER_TABLE);
    }

    public Player(String name){
        this.name = name;
        others_scores=DBParams.getScores(name,DBParams.OTHERS_TABLE);
        computer_scores=DBParams.getScores(name,DBParams.COMPUTER_TABLE);
    }
}
