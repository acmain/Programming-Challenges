import java.math.BigInteger;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger a, b;

		while (in.hasNext()) {
			a = new BigInteger(in.next());
			b = new BigInteger(in.next());

			try {
				if (a.intValueExact() == 0 && b.intValueExact() == 0) {
					break;
				}
			} catch (ArithmeticException e) {
			}

			BigInteger c = new BigInteger("1");
			BigInteger d = new BigInteger("2");
			BigInteger z = new BigInteger("2");
			int count = 0;

			while (true) {
				if ((d.compareTo(a) == 0 || d.compareTo(a) == 1) && (d.compareTo(b) == -1 || d.compareTo(b) == 0)) {
					count++;
				} else if (d.compareTo(b) == 1)
					break;

				z = d;
				d = c.add(d);
				c = z;

				// System.out.println(c.toString() + " " + d.toString());
			}

			if (a.toString().equals("0") || a.toString().equals("1")) {
				if (!(b.toString().equals("1")) && !(b.toString().equals("2")))
					count--;
				count += 2;
			}
			if (a.toString().equals("2")) {
				if (!(b.toString().equals("1")) && !(b.toString().equals("2")))
					count--;
				count++;
			}

			if (b.toString().equals("1"))
				count = 1;
			if (b.toString().equals("2"))
				count = 2;
			if (a.toString().equals(b.toString()) && (a.toString().equals("1") || b.toString().equals("2")))
				count = 1;

			System.out.print(count + "\n");
		}
	}
}
