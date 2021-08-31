package board;

import java.util.InputMismatchException;

import params.GameParams;

public class Board {
    
    public char board[][];
    // char playerOneSymbol,playerTwoSymbol;
    // String playerOneName,playerTwoName;

    public Board(){
        board=new char[3][3];
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j]='-';
			}
		}
    }
    
	public void print() {
        System.out.println();
        for (char[] cs : board) {
            for (char c : cs) {
                System.out.print(c+"\t");
            }
            System.out.println("\n");
        }
		System.out.println();
    }
    
    public void read(char symbol)
	{
		int r,c;
		while(true)
		{
			try
			{
				System.out.print("row : ");
				r=GameParams.SCANNER.nextInt();
				System.out.print("column :");
				c=GameParams.SCANNER.nextInt();
				
				if(r==0||c==0)
				{
					System.out.println("Do not enter 0");
					continue;
				}
				if(board[r-1][c-1]=='-')
				{
					board[r-1][c-1]=symbol;
					break;
				}
				else
					System.out.println("Already Occupied,choose Another\n");
			}
			catch(ArrayIndexOutOfBoundsException ex)
			{
				System.out.println("Tou entered out of bound values");
				System.out.println("Try again\n");
				this.read(symbol);
				break;
			}
			catch(InputMismatchException e){

				char ch=' ';
				while (!(ch=='Y'||ch=='N')) {
					System.out.print("do you want to exit(Y/N): ");
					ch=Character.toUpperCase(GameParams.SCANNER.next().charAt(0));
					
					if (ch=='Y') {
						System.exit(0);
						break;
					}
					else if(ch=='N'){
						break;
					} 
					
				}
			}
		}
	}

    public boolean isWon(char symbol)
	{
		if(board[0][0]==symbol)
			if(board[0][0]==board[1][1]&&board[0][0]==board[2][2])
				return true;
		if(board[0][2]==symbol)
			if(board[0][2]==board[1][1]&&board[0][2]==board[2][0])
				return true;
		for(int i=0;i<3;++i)
		{
			if(board[i][0]==symbol)
				if(board[i][2]==board[i][1]&&board[i][2]==board[i][0])
					return true;
			if(board[0][i]==symbol)
				if(board[2][i]==board[1][i]&&board[2][i]==board[0][i])
					return true;
		}
		return false;
	}
    
	public boolean couldWin(char symbol)
	{
		Board duplicate=new Board();
		for(int i=0;i<=2;++i)
			for(int j=0;j<3;j++)
				if(this.board[i][j]=='-')
					duplicate.board[i][j]=symbol;
				else
					duplicate.board[i][j]=board[i][j];
		if(duplicate.isWon(symbol))
			return true;
		return false;
	}
}
