import java.util.*;
import java.io.*;

class tictactoe
{

	static HashSet<Integer> user_set = new HashSet<Integer>();
	static HashSet<Integer> comp_set = new HashSet<Integer>();

	public static void main(String args[])
	{
		char [][] board = {
			{' ','|',' ','|',' '},
			{'-','-','-','-','-'},
			{' ','|',' ','|',' '},
			{'-','-','-','-','-'},
			{' ','|',' ','|',' '}
			};

	print_board(board);

	Scanner scan = new Scanner(System.in);
	
	while(true)
	{
		System.out.print("Enter the Value[1-9] :");
		int user_pos = scan.nextInt();
		while(user_set.contains(user_pos) || comp_set.contains(user_pos))
		{
			System.out.println();
			System.out.print("Retry!... Already Entered.");
			user_pos = scan.nextInt();
		}
		holder(board,user_pos,"You");

		String res = check_winner();
		if(res.length()>0)
		{
			System.out.println(res);
			break;
		}


		int cpu_pos = gen_random();
		while(user_set.contains(cpu_pos) || comp_set.contains(cpu_pos))
		{
			cpu_pos = gen_random();
		}
		holder(board,cpu_pos,"Comp");
		res = check_winner();
		if(res.length()>0)
		{
			System.out.println(res);
			break;
		}

	
	}
	}

	static String check_winner() {
    int[][] winConditions = {
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, 
        {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, 
        {1, 5, 9}, {3, 5, 7} 
    };

    for (int[] condition : winConditions) {
        HashSet<Integer> winSet = new HashSet<>();
        for (int pos : condition) {
            if (user_set.contains(pos))
                winSet.add(pos);
            else if (comp_set.contains(pos))
                winSet.add(pos);
        }
        if (winSet.size() == 3) {
            if (user_set.containsAll(winSet))
                return "YOU WON";
            else if (comp_set.containsAll(winSet))
                return "YOU LOST";
        }
    }

    if (user_set.size() + comp_set.size() == 9) {
        return "Draw";
    }

    return "";
}

	static int gen_random()
	{
		int max = 9;
		int min = 1;
		int range = max-min+1;
		int res =(int)(Math.random()*range)+min;
		return res;
	
	}
	
	static void print_board(char [][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	static void holder(char[][] board , int pos,String user)
	{
	char sym ='X';
	if(user.equals("You"))
	{
		sym = 'X';
		user_set.add(pos);
	}
	else if(user.equals("Comp")){
		sym = 'O';
		comp_set.add(pos);
	
	}

	switch(pos)
	{
		case 1:
		board[0][0] = sym;
		break;
		case 2:
		board[0][2] = sym;
		break;
		case 3:
		board[0][4] = sym;
		break;
		case 4:
		board[2][0] = sym;
		break;
		case 5:
		board[2][2] = sym;
		break;
		case 6:
		board[2][4] = sym;
		break;
		case 7:
		board[4][0] = sym;
		break;
		case 8:
		board[4][2] = sym;
		break;
		case 9:
		board[4][4] = sym;
		break;
		
		default:
			System.out.println("Invalid Input..Please try again");
	}
	
	print_board(board);

	}

}

