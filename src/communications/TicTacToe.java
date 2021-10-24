package communications;

import gamesource.TwoPlayer;
import gamesource.VsComputer;
import params.GameParams;

public class TicTacToe{
    public TicTacToe(){
        GameParams.welcome();
        System.out.println("\n\n\n");

    }
    public void play(){
        
        System.out.println("Enter 1 for two player mode");
        System.out.println("Enter 2 for vs computer mode");
        System.out.println("Enter e to exit");
        char ch;
        System.out.print("\nEnter Your Choice:");
        ch=GameParams.SCANNER.next().charAt(0);
        
        while(!(ch=='1'||ch=='2'||ch=='e'||ch=='E')){
            
            System.out.print("Enter 1, 2 or e:");
            ch=GameParams.SCANNER.next().charAt(0);
        }
        
        if(ch=='1')
            twoPlayer();
        else if(ch=='2')
            vsComputer();
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

    public void vsComputer(){
        VsComputer vsComputer=new VsComputer();
        vsComputer.play();
    }
}
