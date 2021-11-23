package tictactoecli.communications;

import tictactoecli.board.Player;
import tictactoecli.gamesource.TwoPlayer;
import tictactoecli.gamesource.VsComputer;
import tictactoecli.params.DBParams;
import tictactoecli.params.GameParams;

public class TicTacToe{
    public TicTacToe(){
        DBParams.onCreate();
        GameParams.welcome();
        System.out.println("\n\n\n");

    }
    public void play(){
        
        System.out.println("Enter 1 for two player mode");
        System.out.println("Enter 2 for vs computer mode");
        System.out.println("enter 3 to print score of a particular player by name");
        System.out.println("Enter e to exit");
        char ch;
        System.out.print("\nEnter Your Choice:");
        ch=GameParams.SCANNER.next().charAt(0);
        
        while(!(ch=='1'||ch=='2'||ch=='3'||ch=='e'||ch=='E')){
            
            System.out.print("Enter 1, 2 or e:");
            ch=GameParams.SCANNER.next().charAt(0);
        }
        
        if(ch=='1')
            twoPlayer();
        else if(ch=='2')
            vsComputer();
        else if(ch=='3')
            displayScores();
        else{
            System.out.println("exiting.......");
            System.exit(0);
        }
        this.play();
    }

    public void twoPlayer() {
        TwoPlayer twoPlayerGame=new TwoPlayer();
        twoPlayerGame.play();
        // this.play();
    }
    public void displayScores(){
        System.out.print("\nEnter the name of Player to display score:");
        String name=GameParams.SCANNER.next();
        Player player=new Player(name);

        System.out.println("\nVS OTHERS ==>");
        System.out.println("Total Games:\t"+player.others_scores.total_games);
        System.out.println("Won:\t"+player.others_scores.won);        
        System.out.println("Lost:\t "+player.others_scores.lost);        
        System.out.println("Draw:\t"+player.others_scores.draw);  

        System.out.println("\nVS COMPUTER ==>");
        System.out.println("Total Games:\t"+player.computer_scores.total_games);
        System.out.println("Won:\t\t"+player.computer_scores.won);        
        System.out.println("Lost:\t\t"+player.computer_scores.lost);        
        System.out.println("Draw:\t\t"+player.computer_scores.draw);       
        System.out.println("\n\n"); 
    }
    public void vsComputer(){
        VsComputer vsComputer=new VsComputer();
        vsComputer.play();
    }
}
