import java.util.*;
public class GameOn {
    public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		boolean start=true,gameon=true,playerchange=false;
		int player=1;
		char player1=' ',player2=' ';	
		char [][]board=new char[3][3];
		// Enter Empty Value
		Reset(board);
		printBoard(board);
		//Game Start Here
		while(gameon)
		{
			// Setting Player Symbol
			if(start)
			{
				System.err.print("Tic Tac Toe Game Started ;)\n");
				System.out.print("Player 1 Enter Your Symbol:");
				player1=sc.next().charAt(0);
				System.out.print("\nPlayer 2 Enter Your Symbol:");
				player2=sc.next().charAt(0);
				start=false;
				
			}
			else
			{
				playerchange=(playerchange==false)?true:false;
				player=(playerchange)?1:2;
				System.out.print("Player "+player+" Move :");
				int row=sc.nextInt();
				int col=sc.nextInt();
				sc.nextLine();
				if(!(row<3 && row>=0)||!(col<3 && col >=0))
				{
					System.err.println("Invalid Input :(");
				}
				else if(board[row][col]!=' ')
				{
					System.err.println("Already Occupied");
				}
				else
				{	
				char sign=(player==1)?player1:player2;
				board[row][col]=sign;
				printBoard(board);
				gameon=gameProcess(board, player1, player2);
				}
			}
		}
		

	}
	public static boolean gameProcess(char board[][],char player1,char player2)
	{
		for(int i=0;i<board.length;i++)
		{
			if(board[0][i]==player1 && board[1][i]==player1 && board[2][i]==player1)
			{
				printBoard(board);
				System.err.println("********** Player 1 WON ;)**********");
				return false;
			}
			if(board[0][i]==player2 && board[1][i]==player2 && board[2][i]==player2)
			{
				printBoard(board);
				System.err.println("********** Player 2 WON ;)**********");
				return false;
			}
			if(board[i][0]==player1 && board[i][1]==player1 && board[i][2]==player1)
			{
				printBoard(board);
				System.err.println("********** Player 1 WON ;)**********");
				return false;
			}
			if(board[i][0]==player2 && board[i][1]==player2 && board[i][2]==player2)
			{
				printBoard(board);
				System.err.println("********** Player 2 WON ;)**********");
				return false;
			}
		}
		if((board[0][0]==player1 && board[1][1]==player1 && board[2][2]==player1)||(board[0][1]==player1 && board[1][1]==player1 && board[2][0]==player1))
		{
			printBoard(board);
			System.err.println("********** Player 1 WON ;)**********");
			return false;
		}
		if((board[0][0]==player2 && board[1][1]==player2 && board[2][2]==player2)||(board[0][1]==player2 && board[1][1]==player2 && board[2][0]==player2))
		{
			printBoard(board);
			System.err.println("********** Player 2 WON ;)**********");
			return false;
		}
		//Checking All the Spaces are Fulled
		int occupied=0;
		for(int i=0;i<board.length;i++)
		{
			
			for(int j=0;j<board.length;j++)
			{
				if(board[i][j]!=' ')
					occupied++;
			}
			
		}
		if(occupied<=8)
		{
			printBoard(board);
			System.err.println("********** No Body Won :(**********");
			System.out.print("To Reset Press 1:");
			int reset=sc.nextInt();
			sc.nextLine();
			if(reset==1)
			{
				Reset(board);
				return true;
			}
			else
			{
				System.err.print("Game Ended\nBYE :)");
				return false;
			}
		}
		
		
		return true;
	}
	
	public static void Reset(char board[][])
	{
		printBoard(board);
		for(int i=0;i<board.length;i++)
		{
			
			for(int j=0;j<board.length;j++)
			{
				board[i][j]=' ';
			}
			
		}
	}
	public static void printBoard(char board[][])
	{
		System.err.println("Current Board\n");
		for(int i=0;i<board.length;i++)
		{
			System.out.print("|");
			for(int j=0;j<board.length;j++)
			{
				System.out.print(board[i][j]+"|");
			}
			System.out.println();
		}
	}

}
