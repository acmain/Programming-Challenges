import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		long x, y, dif;

		int cases = 0;

		if (in.hasNextLine()) {
			cases = Integer.parseInt(in.nextLine());
		}

		for (int c = 0; in.hasNextLine() && c < cases; c++) {
			x = Long.parseLong(in.next());
			y = Long.parseLong(in.next());
			dif = y - x;

			if (dif == 0) {
				System.out.print("0\n");
				continue;
			}

			double result;

			result = Math.sqrt(4 * dif) - 1;

			if (result - (int) result != 0)
				result++;

			System.out.print((int) result + "\n");
		}

	}
}
