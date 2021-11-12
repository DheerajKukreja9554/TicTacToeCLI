package tictactoecli.gamesource;

import tictactoecli.board.Board;
import tictactoecli.board.Player;
import tictactoecli.params.GameParams;

public class TwoPlayer{
    
    Player player1;
    Player player2;
    Board board;
    public TwoPlayer(){
        System.out.print("\nPlayer 1, enter your name:");
        String name=GameParams.SCANNER.next();
        System.out.print(name+", choose your symbol(X/O):");
        char ch=Character.toUpperCase(GameParams.SCANNER.next().charAt(0));

        while(!(ch==GameParams.O||ch==GameParams.X)){
            System.out.print("Enter X or O: ");
            ch=Character.toUpperCase(GameParams.SCANNER.next().charAt(0));

        }

        player1 = new Player(name,ch);

        System.out.print("\nPlayer 2, enter your name:");
        name=GameParams.SCANNER.next();
        if(ch==GameParams.O)
            player2 = new Player(name,GameParams.X);
        else
            player2=new Player(name, GameParams.O);
        System.out.println("Your symbol: "+player2.symbol);

        System.out.println("\nROWS AND COLUMNS ARE FROM (1,1) TO (3,3)");
		System.out.println();

    }
    
    public void play() {
        
        board=new Board();
        board.print();
        for (int turn = 0; turn < 9; turn++) {
            if(turn%2==0){
                System.out.println(player1.name+", your turn");
                board.read(player1.symbol);
                board.print();
                if(board.isWon(player1.symbol)){
                    System.out.println("Congrats, "+player1.name+" you won");
                    break;
                }
            }
            else{
                System.out.println(player2.name+"'s, your turn");
                board.read(player2.symbol);
                board.print();
                if(board.isWon(player2.symbol)){
                    System.out.println("Congrats, "+player2.name+" you won");
                    break;
                }
            }
            if((board.couldWin(player1.symbol)==false)&&(board.couldWin(player2.symbol)==false)){
                System.out.println("Game would end in a DRAW");
				break;
			}
        }
        afterPlay();
    }
    public void afterPlay() {
        
        System.out.println("\nEnter 1 to play a new game");
        System.out.println("Enter 2 for new players");
        System.out.println("Enter e to go to previous menu");
        System.out.print("\nEnter your choice:");
        char ch=GameParams.SCANNER.next().charAt(0);
        
        while(!(ch=='1'||ch=='2'||ch=='e'||ch=='E')){
            
            System.out.print("Enter 1, 2 or e:");
            ch=GameParams.SCANNER.next().charAt(0);
        }

        if(ch=='1')
            play();
        else if(ch=='2'){
            // System.out.println(this.getClass());
            (new TwoPlayer()).play();
            // play();
        }
        else{
            System.out.println("\nGoing to previous menu.......\n");
        }
    }
}
