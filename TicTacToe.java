package games;

import java.util.*;
import java.util.Random;
class TicTacToe
{
	Scanner sc=new Scanner (System.in);
	public static void main(String args[])
	{
		Scanner s=new Scanner (System.in);
		TicTacToe ob=new TicTacToe();
		while(true)
		{
			try
			{
				char c;
				System.out.println("1 for 2 player game,\n2 for player vs computer");
				c=s.next().charAt(0);
				if(c=='1')
					ob.play();
				else if (c=='2')
					ob.vsComp();
				else
					System.out.println("Wrong choice. try again");
				System.out.println();
			}
			catch(Exception e)
			{
				System.out.println("Error occured\ntry again with new game");
				
			}
			System.out.print("Do you want to continue(y/n) :");
			while(true)
			{
				char ch=s.next().charAt(0);
				
				if(ch=='n')
				{
					s.close();

					System.exit(0);
				}
				else if(ch=='y')
				break;
				else
				System.out.println("Enter again");
			}

		}
	}
	public void play()
	{
		char board[][],pch1,pch2;
		int turn=0;//counter;
		board=new char[3][3];
		
		for (int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				board[i][j]='-';
		while(true)
		{
			System.out.print("Player 1, Choose your Sysmbol(X/O): ");
			pch1=sc.next().charAt(0);
			pch1=Character.toUpperCase(pch1);
			System.out.println();
			System.out.print("Player 2, your Sysmbol is :");
			if(pch1=='X')
			{
				pch2='O';
				System.out.print("O");
				System.out.println("\n");
				break;
			}
			else if(pch1=='O')
			{
				pch2='X';
				System.out.print("X");System.out.println("\n");
				break;
			}
			else
				System.out.println("\nyou entered Wrong\nEnter Again");
		}
		System.out.println("\n ROWS AND COLUMNS ARE FROM (1,1) TO (3,3)");
		System.out.println();
		while(turn<9)
		{
			printArray(board);
			System.out.println();	
			if(turn%2==0)
			{
				System.out.println("Player 1, your turn");
				//System.out.print("row:");
				read(board,pch1);
				//printArray(board);
				if(isWon(board,pch1))
				{
					System.out.println("player 1,you won");
					break;
				}
			}
			else
			{
				System.out.println("Player 2, your turn");
				//System.out.print("row:");
				read(board,pch2);
					//printArray(board);
					if(isWon(board,pch2))
					{
						System.out.println("player 2,you won");
						break;
					}
				}
			if((couldWin(board,pch1)==false)&&(couldWin(board,pch2)==false))
			{
				System.out.println("Game would end in a DRAW");
				break;
			}
			++turn;
			System.out.println();
		}
		
		if(turn==9)
		System.out.println("game draw");
		
	}
	public void vsComp()
	{
		char board[][],pch1,pch2;
		int turn=0;//counter;
		board=new char[3][3];
		//Random rand=new Random();
		for (int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				board[i][j]='-';
		while(true)
		{
			System.out.print("Player , Choose your Sysmbol(X/O): ");
			pch1=sc.next().charAt(0);
			pch1=Character.toUpperCase(pch1);
			System.out.println();
			//System.out.print("Player 2, your Sysmbol is :");
			if(pch1=='X')
			{
				pch2='O';
				//System.out.print("O");
				System.out.println("YOUR SYMBOL: X \ncOMPUTER'S SYMBOL: O");
				System.out.println("\n");
				break;
			}
			else if(pch1=='O')
			{
				pch2='X';
				System.out.println("YOUR SYMBOL: O \ncOMPUTER'S SYMBOL: X");System.out.println("\n");
				break;
			}
			else
				System.out.println("\nyou entered Wrong\nEnter Again");
		}
		System.out.println("\n ROWS AND COLUMNS ARE FROM (1,1) TO (3,3)");
		System.out.println();
		printArray(board);
		while(turn<9)
		{
			//printArray(board);
			System.out.println();	
			if(turn%2==0)
			{
				System.out.println("Player, your turn");
				System.out.println();
				read(board,pch1);
				printArray(board);
				if(isWon(board,pch1))
				{
					System.out.println("player ,you won");
					break;
				}
			}
			else
			{
				System.out.println("Computer, turn");
				//System.out.print("row:");
				/*int r=1;
				int c=1;
				while(board[r][c]!='-')
				{
					r=rand.nextInt(3);
					c=rand.nextInt(3);
				}
				board[r][c]=pch2;//printArray(board);*/
				compTurn(board,pch2,pch1);
				printArray(board);
				if(isWon(board,pch2))
				{
					//printArray(board);
					System.out.println("Computer won");
					break;
				}
			}
			if((couldWin(board,pch1)==false)&&(couldWin(board,pch2)==false))
			{
				System.out.println("Game would end in a DRAW");
				break;
			}
			++turn;
			System.out.println();
		}
		
		if(turn==9)
		System.out.println("game draw");
		
	}
	public void read(char board[][],char symbol)
	{
		int r,c;
		while(true)
		{
			try
			{
				System.out.print("row : ");
				r=sc.nextInt();
				System.out.print("column :");
				c=sc.nextInt();
				
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
					System.out.println("Already Occupied,choose Another");
			}
			catch(ArrayIndexOutOfBoundsException ex)
			{
				System.out.println("you entered out of bound values");
				System.out.println("try again");
				this.read(board,symbol);
				break;
			}
		}
	}
	public boolean isWon(char board[][],char symbol)
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
	public boolean couldWin(char board[][],char symbol)
	{
		char dup[][]=new char[3][3];
		//printArray(dup);
		for(int i=0;i<=2;++i)
			for(int j=0;j<3;j++)
				if(board[i][j]=='-')
					dup[i][j]=symbol;
				else
					dup[i][j]=board[i][j];
		if(isWon(dup,symbol))
			return true;
		return false;
	}
	public void compTurn(char board[][],char symbol,char opp)
	{
		int r=4,c=4;
		while(true)
		{
			//conquer the mid block
			if(board[1][1]=='-')
			{
				r=1;
				c=1;
				break;
			}
			//computer win if two already filled
			for(int i=0;i<3;i++)
			{
				if(board[i][0]==symbol)
				{
					if((board[i][1]==symbol)&&(board[i][2]=='-'))
					{
						r=i;
						c=2;
						break;
					}
					if((board[i][2]==symbol)&&(board[i][1]=='-'))
					{
						r=i;
						c=1;
						break;
					}
				}
				if(board[0][i]==symbol)
				{
					if((board[1][i]==symbol)&&(board[2][i]=='-'))
					{
						r=2;
						c=i;
						break;
					}
					if((board[2][i]==symbol)&&(board[1][i]=='-'))
					{
						r=1;
						c=i;
						break;
					}
				}
				if(board[i][1]==symbol)
				{
					if((board[i][2]==symbol)&&(board[i][0]=='-'))
					{
						r=i;
						c=0;
						break;
					}
				}
				if(board[1][i]==symbol)
				{
					if((board[2][i]==symbol)&&(board[0][i]=='-'))
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
			if(((board[0][0]==opp)&&(board[2][2]==opp))||((board[0][2]==opp)&&(board[2][0]==opp)))
			{
				if(board[1][0]=='-')
				{
					r=1;
					c=0;
					break;
				}
				
			}
			//opposition win minimum,block if two elements of diagnol already filled
			if(board[1][1]==opp)
			{
				if((board[0][0]==opp)&&(board[2][2]=='-'))
				{
					r=2;
					c=2;
					break;
				}
			
				if((board[0][2]==opp)&&(board[2][0]=='-'))
				{
					r=2;
					c=0;
					break;
				}
				if((board[2][0]==opp)&&(board[0][2]=='-'))
				{
					r=0;
					c=2;
					break;
				}
				if((board[2][2]==opp)&&(board[0][0]=='-'))
				{
					r=0;
					c=0;
					break;
				}
			}
			//opposition win minimum,block if two elements of row or column already filled
			for(int i=0;i<3;i++)
			{
				if(board[i][0]==opp)
				{
					if((board[i][1]==opp)&&(board[i][2]=='-'))
					{
						r=i;
						c=2;
						break;
					}
					if((board[i][2]==opp)&&(board[i][1]=='-'))
					{
						r=i;
						c=1;
						break;
					}
				}
				if(board[0][i]==opp)
				{
					if((board[1][i]==opp)&&(board[2][i]=='-'))
					{
						r=2;
						c=i;
						break;
					}
					if((board[2][i]==opp)&&(board[1][i]=='-'))
					{
						r=1;
						c=i;
						break;
					}
				}
				if(board[i][1]==opp)
				{
					if((board[i][2]==opp)&&(board[i][0]=='-'))
					{
						r=i;
						c=0;
						break;
					}
				}
				if(board[1][i]==opp)
				{
					if((board[2][i]==opp)&&(board[0][i]=='-'))
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
			if(board[1][1]==symbol)
			{
				if((board[0][0]==symbol)&&(board[2][2]=='-'))
				{
					r=2;
					c=2;
					break;
				}
			
				if((board[0][2]==symbol)&&(board[2][0]=='-'))
				{
					r=2;
					c=0;
					break;
				}
				if((board[2][0]==symbol)&&(board[0][2]=='-'))
				{
					r=0;
					c=2;
					break;
				}
				if((board[2][2]==symbol)&&(board[0][0]=='-'))
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
			while(board[r][c]!='-')
				{
					r=rand.nextInt(3);
					c=rand.nextInt(3);
				}
		}
		board[r][c]=symbol;
		
	}

	public void printArray(char board[][])
	{
		for(int i=0;i<=2;++i)
		{
			for(int j=0;j<3;j++)
				System.out.print(board[i][j]+"\t");
			System.out.println();
		}
	}
}
