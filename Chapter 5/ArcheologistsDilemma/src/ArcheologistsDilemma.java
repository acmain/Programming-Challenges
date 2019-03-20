import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			int num = Integer.parseInt(in.nextLine());
			int power = -1;

			double logLow = Math.log10(num) / Math.log10(2); //log base 2 of input
			double logHigh = Math.log10(num + 1) / Math.log10(2); //log base 2 of input + 1
			double log2of10 = Math.log10(10) / Math.log10(2); //log base 2 of 10
			double value = Math.ceil(Math.log10(num + .5)) + 1;
			
			for (; Math.ceil(logLow + value * log2of10) != Math.floor(logHigh + value * log2of10); value++) {
			}
			power = (int) Math.ceil(logLow + value * log2of10);
			
			if (power > -1)
				System.out.print(power + "\n");
			else
				System.out.print("no power of 2\n");
		}
	}

}
