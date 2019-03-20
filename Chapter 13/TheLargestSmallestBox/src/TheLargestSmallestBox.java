import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			String[] t = in.nextLine().split(" ");

			double l = Double.parseDouble(t[0]);
			double w = Double.parseDouble(t[1]);

			double max, min;

			max = (l + w - Math.sqrt(l * l + w * w - l * w)) / 6;
			min = Math.min(l, w) / 2 + (1e-8);

			System.out.printf("%.3f 0.000 %.3f\n", max, min);

		}

	}

}
