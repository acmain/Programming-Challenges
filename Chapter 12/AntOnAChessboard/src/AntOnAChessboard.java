import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			int step = Integer.parseInt(in.nextLine());

			if (step == 0)
				break;
			double sqrt = Math.sqrt(step);
			int a, b;
			if (sqrt - (int) sqrt == 0) {
				if (sqrt % 2 == 1) {
					a = 1;
					b = (int) sqrt;
				} else {
					a = (int) sqrt;
					b = 1;
				}
			} else {
				sqrt = (int) sqrt;
				int remain = (int) (step - Math.pow(sqrt, 2));
				if (sqrt % 2 == 0) {
					if (remain <= sqrt + 1) {
						a = (int) (sqrt + 1);
						b = remain;
					} else {
						a = (int) ((sqrt + 1) * 2 - remain);
						b = (int) (sqrt + 1);
					}
				} else {
					if (remain <= sqrt + 1) {
						a = remain;
						b = (int) (sqrt + 1);
					} else {
						a = (int) (sqrt + 1);
						b = (int) ((sqrt + 1) * 2 - remain);
					}
				}
			}

			System.out.print(a + " " + b + "\n");

		}
	}

}
