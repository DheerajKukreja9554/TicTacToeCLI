package communications;

import gamesource.TwoPlayer;
import gamesource.VsComputer;
import params.GameParams;

public class TicTacToe{

    public void play(){
        GameParams.welcome();
        System.out.println("\n\n\n");
        System.out.println("Enter 1 for two player mode");
        System.out.println("Enter 2 for vs computer mode");
        System.out.println("Enter e to exit");
        char ch;
        System.out.print("\nEnter Your Choice:");
        ch=GameParams.SCANNER.next().charAt(0);
        
        while(ch!='e'){
            if(ch=='1')
                twoPlayer();
            else if(ch=='2')
                vsComputer();
            else if(ch=='e'||ch=='E')
                System.out.println("exiting.......");
            else{
                System.out.print("Enter 1, 2 or e:");
                ch=GameParams.SCANNER.next().charAt(0);
            }
        }
    }

    public void twoPlayer() {
        TwoPlayer twoPlayer=new TwoPlayer();
        twoPlayer.playNew();
    }

    public void vsComputer(){
        VsComputer vsComputer=new VsComputer();
        vsComputer.playNew();
    }
}
