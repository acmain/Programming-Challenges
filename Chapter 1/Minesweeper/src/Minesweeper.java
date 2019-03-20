/* @JUDGE_ID: 946699 10189 JAVA "Dynamic Programming" */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Alex Main
//1.6.2 Minesweeper
//PC/UVa IDs: 110102/10189, Popularity: A, Success rate: high Level: 1

class Main {
	
	public static int compare(char out) {
		if(out == '*')
			return 1;
		else
			return 0;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		boolean loop = true;
		int fieldCount = 0;
		String[] output = new String[10000];
		
		Scanner in = new Scanner(System.in);
		while(loop == true) {
			
			int height = 0;
			if(in.hasNext()) {
				height = in.nextInt();
			}
			
			int width = 0;
			if(in.hasNext()) {
				width = in.nextInt();
			}
			
			
			char[][] board = new char[height][width];
			
			//will default to 0,0 if either dimension is not in range
			if(height <= 0 || height > 100 || width <= 0 || width > 100)
				width = height = 0;
			
			if(width == 0) {
				loop = false;
				break;
			}
			
			if(width != 0) {
				//allow board info to be put in
				for(int i = 0; i < height; i++) {
					String row = "";
					if(in.hasNext()) {
						row = in.next();
					}
					int length = row.length();
					if(length - 1 < width) {
						for(int j = 0; j < width - length; j++) {
							row += ".";
						}
					}
					for(int j = 0; j < width; j++) {
						if(row.charAt(j) == '*')
							board[i][j] = row.charAt(j);
						else //default to empty if not bomb
							board[i][j] = '.';
					}
				}
			}
			
			//process board
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					char cell = board[i][j];
					int adjCount = 0;
					if(cell == '*') { }
					else {
						if(i != 0 && j != 0)
							adjCount += compare(board[i-1][j-1]);
						if(i != 0)
							adjCount += compare(board[i-1][j]);
						if(i != 0 && j != width - 1)
							adjCount += compare(board[i-1][j+1]);
						if(j != 0)
							adjCount += compare(board[i][j-1]);
						if(j != width - 1)
							adjCount += compare(board[i][j+1]);
						if(i != height - 1 && j != 0)
							adjCount += compare(board[i+1][j-1]);
						if(i != height - 1)
							adjCount += compare(board[i+1][j]);
						if(i != height - 1 && j != width - 1)
							adjCount += compare(board[i+1][j+1]);
						
						board[i][j] = Integer.toString(adjCount).charAt(0);
					}
				}
			}
			
			//convert board to string
			output[fieldCount] = "";
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					if(j == width - 1) {
						output[fieldCount] += board[i][j] + "\n";
					}
					else {
						output[fieldCount] += board[i][j];
					}
				}
			}
			fieldCount++;
		}
		
		//display boards
		int i = 0;
		while(output[i] != null) {
			System.out.printf("Field #%d:\n%s", i + 1, output[i]);
			i++;
			if (i != fieldCount)
				System.out.print("\n");
		}
		
		in.close();
		System.exit(0);
	}

}
