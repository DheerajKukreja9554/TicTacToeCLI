package gamesource;

import java.util.Random;

import board.Board;
import board.Player;
import params.GameParams;

public class VsComputer {
    Player player;
    Player computer;
    Board board;
    int first;
	// public VsComputer(){

	// }
	public void timeLoop() {
		for (long i = 0; i < 900000000; i++) {
			if (i%300000000==0) {
				for (Long j = (long)0; j < 300000000; j++) {}
				System.out.print(">>>");
			}
		}
		System.out.println();
	}
    public VsComputer() {
        System.out.print("\nPlayer, enter your name:");
        String name = GameParams.SCANNER.next();
        System.out.print(name + ", choose your symbol(X/O):");
        char ch = Character.toUpperCase(GameParams.SCANNER.next().charAt(0));

        while (!(ch == GameParams.O || ch == GameParams.X)) {
            System.out.print("Enter X or O: ");
            ch = Character.toUpperCase(GameParams.SCANNER.next().charAt(0));

        }

        player = new Player(name, ch);

        computer = new Player("Computer", player.symbol == GameParams.O ? GameParams.X : GameParams.O);

        System.out.println("\nEnter 1 to play first");
        System.out.println("Enter 2 to play second");
        System.out.print("\nEnter your choice:");
		ch=Character.toUpperCase(GameParams.SCANNER.next().charAt(0));;
        while (!(ch == '1' || ch == '2')) {
            System.out.print("Enter 1 or 2: ");
            ch = Character.toUpperCase(GameParams.SCANNER.next().charAt(0));
        }
		System.out.println("\nROWS AND COLUMNS ARE FROM (1,1) TO (3,3)");
		// System.out.println();

		first = ch == '1' ? 1 : 2;
        System.out.println();
        
    }

    public void play() {

        board=new Board();
        for (int turn = 0; turn < 9; turn++) {
            if (turn % 2 == 0) {
                if (first == 1) {
                    System.out.println(player.name + ", your turn");
                    board.read(player.symbol);
                    board.print();
                    if (board.isWon(player.symbol)) {
                        System.out.println("Congrats, " + player.name + " you won");
                        break;
                    }
                } else {
                    System.out.println(computer.name + "'s turn");
					timeLoop();
                    compTurn(board, computer.symbol, player.symbol);
                    board.print();
                    if (board.isWon(computer.symbol)) {
                        System.out.println("Well tried, but " + computer.name + " won");
                        break;
                    }
                }
            } else {
                if (first == 2) {
                    System.out.println(player.name + ", your turn");
                    board.read(player.symbol);
                    board.print();
                    if (board.isWon(player.symbol)) {
                        System.out.println("Congrats, " + player.name + " you won");
                        break;
                    }
                } else {
                    System.out.println(computer.name + " turn");
					timeLoop();
                    compTurn(board, computer.symbol, player.symbol);
                    board.print();
                    if (board.isWon(computer.symbol)) {
                        System.out.println("Well tried, but " + computer.name + " won");
                        break;
                    }
                }
            }
            if(!(board.couldWin(player.symbol)&&board.couldWin(computer.symbol))){
                System.out.println("You Played well\nGame ends in a Draw");
				break;
            }
        }
		afterPlay();

	}
	public void afterPlay() {	
	    System.out.println("\nEnter 1 to play a new game");
        System.out.println("Enter 2 for new player");
        System.out.println("Enter e to go to previous menu");
        System.out.print("Enter your choice:");
        char ch=GameParams.SCANNER.next().charAt(0);
        
        while(!(ch=='1'||ch=='2'||ch=='e')){
            System.out.print("Enter 1, 2 or e:");
            ch=GameParams.SCANNER.next().charAt(0);
        }
		System.out.println();
        if(ch=='1')
            play();
        else if(ch=='2')
            (new VsComputer()).play();
        else{
            System.out.println("Going to previous menu.....\n");
        }
    }
    public void compTurn(Board board,char symbol,char opp)
	{
		int r=4,c=4;
		while(true){

			//conquer the mid block
			if(board.board[1][1]=='-')
			{
				r=1;
				c=1;
				break;
			}
			//computer win if two already filled
			for(int i=0;i<3;i++)
			{
				if(board.board[i][0]==symbol)
				{
					if((board.board[i][1]==symbol)&&(board.board[i][2]=='-'))
					{
						r=i;
						c=2;
						break;
					}
					if((board.board[i][2]==symbol)&&(board.board[i][1]=='-'))
					{
						r=i;
						c=1;
						break;
					}
				}
				if(board.board[0][i]==symbol)
				{
					if((board.board[1][i]==symbol)&&(board.board[2][i]=='-'))
					{
						r=2;
						c=i;
						break;
					}
					if((board.board[2][i]==symbol)&&(board.board[1][i]=='-'))
					{
						r=1;
						c=i;
						break;
					}
				}
				if(board.board[i][1]==symbol)
				{
					if((board.board[i][2]==symbol)&&(board.board[i][0]=='-'))
					{
						r=i;
						c=0;
						break;
					}
				}
				if(board.board[1][i]==symbol)
				{
					if((board.board[2][i]==symbol)&&(board.board[0][i]=='-'))
					{
						r=0;
						c=i;
						break;
					}
				}
			}
			if(r!=4)
				break;
			
			//special case
			if(((board.board[0][0]==opp)&&(board.board[2][2]==opp))||((board.board[0][2]==opp)&&(board.board[2][0]==opp)))
			{
				if(board.board[1][0]=='-')
				{
					r=1;
					c=0;
					break;
				}
				
			}
			//opposition win minimum,block if two elements of diagnol already filled
			if(board.board[1][1]==opp)
			{
				if((board.board[0][0]==opp)&&(board.board[2][2]=='-'))
				{
					r=2;
					c=2;
					break;
				}
			
				if((board.board[0][2]==opp)&&(board.board[2][0]=='-'))
				{
					r=2;
					c=0;
					break;
				}
				if((board.board[2][0]==opp)&&(board.board[0][2]=='-'))
				{
					r=0;
					c=2;
					break;
				}
				if((board.board[2][2]==opp)&&(board.board[0][0]=='-'))
				{
					r=0;
					c=0;
					break;
				}
			}
			//opposition win minimum,block if two elements of row or column already filled
			for(int i=0;i<3;i++)
			{
				if(board.board[i][0]==opp)
				{
					if((board.board[i][1]==opp)&&(board.board[i][2]=='-'))
					{
						r=i;
						c=2;
						break;
					}
					if((board.board[i][2]==opp)&&(board.board[i][1]=='-'))
					{
						r=i;
						c=1;
						break;
					}
				}
				if(board.board[0][i]==opp)
				{
					if((board.board[1][i]==opp)&&(board.board[2][i]=='-'))
					{
						r=2;
						c=i;
						break;
					}
					if((board.board[2][i]==opp)&&(board.board[1][i]=='-'))
					{
						r=1;
						c=i;
						break;
					}
				}
				if(board.board[i][1]==opp)
				{
					if((board.board[i][2]==opp)&&(board.board[i][0]=='-'))
					{
						r=i;
						c=0;
						break;
					}
				}
				if(board.board[1][i]==opp)
				{
					if((board.board[2][i]==opp)&&(board.board[0][i]=='-'))
					{
						r=0;
						c=i;
						break;
					}
				}
			}
			if(r!=4)
				break;
			//computers win max
			if(board.board[1][1]==symbol)
			{
				if((board.board[0][0]==symbol)&&(board.board[2][2]=='-'))
				{
					r=2;
					c=2;
					break;
				}
			
				if((board.board[0][2]==symbol)&&(board.board[2][0]=='-'))
				{
					r=2;
					c=0;
					break;
				}
				if((board.board[2][0]==symbol)&&(board.board[0][2]=='-'))
				{
					r=0;
					c=2;
					break;
				}
				if((board.board[2][2]==symbol)&&(board.board[0][0]=='-'))
				{
					r=2;
					c=2;
					break;
				}
			}
			break;
		}
		if(r==4)
		{
			r=1;c=1;
			Random rand=new Random();
			while(board.board[r][c]!='-')
				{
					r=rand.nextInt(3);
					c=rand.nextInt(3);
				}
		}
		board.board[r][c]=symbol;
		
	}

}
