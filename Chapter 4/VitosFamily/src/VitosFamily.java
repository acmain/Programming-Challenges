import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = 0;

		if (in.hasNextLine())
			cases = Integer.parseInt(in.nextLine());

		for (int c = 0; in.hasNextLine() && c < cases; c++) {
			String line = in.nextLine();
			Scanner scan = new Scanner(line);

			int houses = 0;
			if (scan.hasNextInt())
				houses = scan.nextInt();

			int[] houseNums = new int[houses];

			for (int h = 0; scan.hasNextInt() && h < houses; h++) {
				houseNums[h] = scan.nextInt();
			}

			Arrays.sort(houseNums);

			// calculate median
			int median;
			if (houses % 2 == 1) {
				median = houses / 2;
			} else {
				median = ((houses / 2) + (houses / 2 + 1)) / 2;
			}

			int totDist = 0;
			for (int i = 0; i < houseNums.length; i++) {
				totDist += Math.abs(houseNums[median] - houseNums[i]);
			}

			System.out.print(totDist + "\n");

		}
	}

}
