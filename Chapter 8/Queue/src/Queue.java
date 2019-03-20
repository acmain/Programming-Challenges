import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int people, left, right;

		int cases = 0;
		if (in.hasNextLine())
			cases = Integer.parseInt(in.nextLine());

		// calculate all possible values beforehand
		long[][][] values = new long[15][15][15];//not sure why runtime error using 14?
		values[1][1][1] = 1;
		for (people = 2; people <= 13; people++) {
			for (left = 1; left <= people; left++) {
				for (right = 1; right <= people; right++) {
					values[people][left][right] = values[people - 1][left - 1][right]
							+ values[people - 1][left][right - 1] + (values[people - 1][left][right] * (people - 2));
				}
			}
		}

		for (int c = 0; c < cases; c++) {
			String[] tokens = new String[3];
			if (in.hasNextLine())
				tokens = in.nextLine().split(" ");

			people = Integer.parseInt(tokens[0]);
			left = Integer.parseInt(tokens[1]);
			right = Integer.parseInt(tokens[2]);

			System.out.print(values[people][left][right] + "\n");

		}

	}

}
