import java.util.Scanner;

/* @JUDGE_ID: 946699 10050 JAVA "Dynamic Programming" */

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = 0;

		if (in.hasNextLine())
			cases = Integer.parseInt(in.nextLine());

		for (int z = 0; z < cases; z++) {
			int days = 0;
			int parties = 0;

			if (in.hasNextLine())
				days = Integer.parseInt(in.nextLine());
			if (in.hasNextLine())
				parties = Integer.parseInt(in.nextLine());

			boolean[][] table = new boolean[parties][days];

			for (int y = 0; in.hasNextLine() && y < parties; y++) {
				int interval = Integer.parseInt(in.nextLine());
				for (int x = interval - 1; x < days; x = x + interval)
					table[y][x] = true;
			}

			int hartals = 0;
			for (int i = 0; i < days; i++) {
				if (i % 7 == 5 || i % 7 == 6) {
				} else {
					for (int j = 0; j < parties; j++) {
						if (table[j][i] == true) {
							hartals++;
							break;
						}
					}
				}
			}
			
			System.out.printf("%d\n", hartals);

			/*
			 * //debug for(int i = 0; i < parties; i++) { for(int j = 0; j < days; j++) {
			 * System.out.print(table[i][j]); } System.out.print("\n"); }
			 */
		}
	}
}

/*
 * 1 14 3 3 4 8
 * 
 */