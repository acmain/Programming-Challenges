/* @JUDGE_ID: 946699 706 JAVA "Dynamic Programming" */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int size = 1;
		String num = "";
		String input = "";
		
		do {
			if(in.hasNextLine())
				input = in.nextLine();
			
			Scanner scan = new Scanner(input);
			ArrayList<char[][]> digits = new ArrayList<char[][]>();
			if(scan.hasNextInt())
				size = scan.nextInt();
			if(scan.hasNext())
				num = scan.next();
			
			int length = num.length();			
			char[][] arr = new char[size * 2 + 3][size + 2];
			draw(size, num, digits);
			scan.close();
			
			int totalSize = ((size + 3) * length) - 1;
			char[][] display = new char[size * 2 + 3][totalSize];
			
			for(int i = 0; i < (size * 2 + 3); i++) {//iterates rows
				for(int j = 0; j < digits.size(); j++) { //iterates digits
					for(int k = 0; k < (size + 2); k++) { //iterates columns
						if(j == 0)
							display[i][k] = digits.get(j)[i][k];
						else
							display[i][(j * (size + 2) + j) + k] = digits.get(j)[i][k];
					}
				}
			}
			
			System.out.print("\n");
			for(int i = 0; i < size * 2 + 3; i++) {
				for(int j = 0; j < totalSize; j++) {
					System.out.print(display[i][j]);
				}
				System.out.print("\n");
			}
			
			
		} while(in.hasNextLine() && size != 0);
		
		System.out.print("\n");
		in.close();
	}
	
public static void draw(int size, String num, ArrayList<char[][]> arrList) {
		
		for(int i = 0; i < num.length(); i++) {
			char[][] arr = new char[size * 2 + 3][size + 2];
			int digit = Character.getNumericValue(num.charAt(i));
			boolean[] verts = new boolean[4];
			boolean[] horiz = new boolean[3];
			
			//decide which zones go active
			if(digit == 4 || digit == 5 || digit == 6 || digit == 8 || digit == 9 || digit == 0)
				verts[0] = true;
			if(digit == 4 || digit == 1 || digit == 8 || digit == 9 || digit == 0 || digit == 2 || digit == 3 || digit == 7)
				verts[1] = true;
			if(digit == 2 || digit == 6 || digit == 8 || digit == 0)
				verts[2] = true;
			if(digit == 4 || digit == 5 || digit == 6 || digit == 8 || digit == 9 || digit == 0 || digit == 7 || digit == 1 || digit == 3)
				verts[3] = true;
			if(digit == 2 || digit == 5 || digit == 6 || digit == 8 || digit == 9 || digit == 0 || digit == 3 || digit == 7)
				horiz[0] = true;
			if(digit == 4 || digit == 5 || digit == 6 || digit == 8 || digit == 9 || digit == 2 || digit == 3)
				horiz[1] = true;
			if(digit == 3 || digit == 5 || digit == 6 || digit == 8 || digit == 9 || digit == 0 || digit == 2)
				horiz[2] = true;
			
			//draw active zones
			if(verts[0] == true)
				for(int j = 0; j < size; j++)
					arr[1 + j][0] = '|';
			if(verts[1] == true)
				for(int j = 0; j < size; j++)
					arr[1 + j][size + 1] = '|';
			if(verts[2] == true)
				for(int j = 0; j < size; j++)
					arr[(size * 2 + 1) - j][0] = '|';
			if(verts[3] == true)
				for(int j = 0; j < size; j++)
					arr[(size * 2 + 1) - j][size + 1] = '|';
			if(horiz[0] == true)
				for(int j = 0; j < size; j++)
					arr[0][1 + j] = '-';
			if(horiz[1] == true)
				for(int j = 0; j < size; j++)
					arr[(size * 2 + 2)/2][1 + j] = '-';
			if(horiz[2] == true)
				for(int j = 0; j < size; j++)
					arr[(size * 2 + 2)][1 + j] = '-';
			
			arrList.add(arr);
			
		}
		
	}

}
