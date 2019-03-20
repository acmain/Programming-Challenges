
/* @JUDGE_ID: 946699 10010 JAVA "Dynamic Programming" */
import java.util.ArrayList;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int scenarios = 0;

		if (in.hasNextLine())
			scenarios = Integer.parseInt(in.nextLine());

		for (int s = 0; in.hasNextLine() && s < scenarios; s++) {
			// process blank line
			String blank = in.nextLine();

			int height = 0, width = 0;

			if (in.hasNextLine()) {
				String line = in.nextLine();
				String[] tokens = line.split(" ");
				height = Integer.parseInt(tokens[0]);
				width = Integer.parseInt(tokens[1]);
			}

			char[][] grid = new char[height][width];

			// get gridlines
			for (int h = 0; in.hasNextLine() && h < height; h++) {
				String line = in.nextLine().toLowerCase();
				for (int c = 0; c < line.length(); c++) {
					grid[h][c] = line.charAt(c);
				}
			}

			/*
			 * // debug for (int i = 0; i < height; i++) { for (int j = 0; j < width; j++) {
			 * System.out.print(grid[i][j]); } System.out.print("\n"); }
			 */

			// get # words
			int numWords = 0;
			if (in.hasNextLine())
				numWords = Integer.parseInt(in.nextLine());

			// get words
			String[] words = new String[numWords];
			for (int w = 0; in.hasNextLine() && w < numWords; w++) {
				words[w] = in.nextLine().toLowerCase();
			}

			// search grid to find words
			for (int i = 0; i < numWords; i++) {
				boolean loop = true;
				Point point = new Point(-1, 0);
				while (loop) {
					if (point.getX() != width - 1 && point.getY() != height - 1)
						point = findChar(point.getY(), point.getX() + 1, words[i].charAt(0), grid);
					else if (point.getX() == width - 1 && point.getY() != height - 1)
						point = findChar(point.getY() + 1, 0, words[i].charAt(0), grid);
					else if (point.getY() == height - 1){
						point = findChar(point.getY(), point.getX() + 1, words[i].charAt(0), grid);
					}
					else {
						System.out.println("Here");
					}

					if (point.getX() == -1) {
						System.out.print(
								words[i].charAt(0) + " not found after " + point.getX() + "," + point.getY() + "\n");
						break;
					}
					if (beginFindWord(point.getY(), point.getX(), words[i], grid))
						loop = false;

				}
				System.out.printf("%d %d\n", point.getY() + 1, point.getX() + 1);
			}
			if(s != scenarios - 1)
				System.out.print("\n");
		}

	}

	public static Point findChar(int startRow, int startCol, char character, char[][] arr) {
		Point point = new Point(-1, 0);

		int r = startRow;
		for (int j = startCol; j < arr[0].length; j++) {
			if (arr[r][j] == character) {
				point.set(j, r);
				return point;
			}
		}
		if (startRow != arr.length) {
			for (int i = startRow + 1; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					if (arr[i][j] == character) {
						point.set(j, i);
						return point;
					}
				}
			}
		}
		return point;

	}

	public static boolean beginFindWord(int x, int y, String word, char[][] grid) {
		if (word.length() == 1) {
			return true;
		} else {
			// up and left
			if (findWord(x - 1, y + 1, word, grid, 1, "UL"))
				return true;
			// up
			if (findWord(x, y + 1, word, grid, 1, "U"))
				return true;
			// up and right
			if (findWord(x + 1, y + 1, word, grid, 1, "UR"))
				return true;
			// right
			if (findWord(x + 1, y, word, grid, 1, "R"))
				return true;
			// down and right
			if (findWord(x + 1, y - 1, word, grid, 1, "DR"))
				return true;
			// down
			if (findWord(x, y - 1, word, grid, 1, "D"))
				return true;
			// down and left
			if (findWord(x - 1, y - 1, word, grid, 1, "DL"))
				return true;
			// left
			if (findWord(x - 1, y, word, grid, 1, "L"))
				return true;
		}

		return false;
	}

	public static boolean findWord(int x, int y, String word, char[][] grid, int numLoop, String dir) {
		// debug
		// System.out.println(x + " " + y + " " + word + " " + numLoop + " " + dir);

		// check bounds
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
			return false;
		else if (word.length() == numLoop) {
			return false;
		}
		// check if correct char
		else if (word.charAt(numLoop) != grid[x][y]) {
			return false;
		}
		// check if word complete
		else if (numLoop == word.length() - 1 && word.charAt(numLoop) == grid[x][y]) {
			return true;
		}
		// recur if correct char
		else if (word.charAt(numLoop) == grid[x][y]) {
			// up and left
			if (dir.equals("UL") && findWord(x - 1, y + 1, word, grid, numLoop + 1, "UL"))
				return true;
			// up
			else if (dir.equals("U") && findWord(x, y + 1, word, grid, numLoop + 1, "U"))
				return true;
			// up and right
			else if (dir.equals("UR") && findWord(x + 1, y + 1, word, grid, numLoop + 1, "UR"))
				return true;
			// right
			else if (dir.equals("R") && findWord(x + 1, y, word, grid, numLoop + 1, "R"))
				return true;
			// down and right
			else if (dir.equals("DR") && findWord(x + 1, y - 1, word, grid, numLoop + 1, "DR"))
				return true;
			// down
			else if (dir.equals("D") && findWord(x, y - 1, word, grid, numLoop + 1, "D"))
				return true;
			// down and left
			else if (dir.equals("DL") && findWord(x - 1, y - 1, word, grid, numLoop + 1, "DL"))
				return true;
			// left
			else if (dir.equals("L") && findWord(x - 1, y, word, grid, numLoop + 1, "L"))
				return true;
		}

		return false;
	}

}

class Point {
	int x, y;

	Point() {
		this.x = 0;
		this.y = 0;
	}

	Point(int x, int y) {
		set(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void print() {
		System.out.print("(" + x + "," + y + ")\n");
	}
}
