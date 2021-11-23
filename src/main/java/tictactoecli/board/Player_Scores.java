package tictactoecli.board;

public class Player_Scores {
    
    public String player_name;
    public int total_games;
    public int won;
    public int draw;
    public int lost;
    public Player_Scores(String player_name,int total_games, int won, int lost, int draw) {
        this.player_name=player_name;
        this.total_games = total_games;
        this.won = won;
        this.lost = lost;
        this.draw = draw;
    }
    
}
