import java.util.Scanner;

/* @JUDGE_ID: 946699 10082 JAVA "Dynamic Programming" */


class Main {

	public static void main(String[] args) {
		char[] line1 = "`1234567890-=".toCharArray();
		char[] line2 = "QWERTYUIOP[]\\".toCharArray();
		char[] line3 = "ASDFGHJKL;'".toCharArray();
		char[] line4 = "ZXCVBNM,./".toCharArray();
		
		char[][] keyboard = new char[4][13];
		addToArray(keyboard, line1, 0);
		addToArray(keyboard, line2, 1);
		addToArray(keyboard, line3, 2);
		addToArray(keyboard, line4, 3);
		
		/*//debug - print 2d array
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				if(keyboard[i][j] != '\0')
					System.out.print(keyboard[i][j] + " ");
			}
			System.out.print("\n");
		}*/
		
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()) {
			String line = in.nextLine();
			char[] lineArr = line.toCharArray();
			
			for(int i = 0; i < line.length(); i++) {
				if(lineArr[i] != ' ') {
					lineArr[i] = offsetChar(lineArr[i], keyboard);
				}
			}
			
			String newLine = new String(lineArr);
			System.out.print(newLine + "\n");
		}
	}
	
	public static void addToArray(char[][] dest, char[] from, int lineNum) {
		for(int i = 0; i < from.length; i++) {
			dest[lineNum][i] = from[i];
		}
	}
	
	public static char offsetChar(char ch, char[][] in) {
		for(int i = 0; i < in.length; i++) {
			for(int j = 1; j < in[0].length; j++) {
				if(ch == in[i][j]) {
					return in[i][j-1];
				}
			}
		}
		return '\0';
	}

}
