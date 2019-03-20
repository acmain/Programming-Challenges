import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()) {
			String[] tokens = in.nextLine().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			
			if(a == b) {
				System.out.printf("%d %d %d\n", 0, 1, a);
			} else {
				int[] gcd = GCD(a,b);
				System.out.printf("%d %d %d\n", gcd[0], gcd[1], gcd[2]);
			}
			
			
			
			
		}
	}
	
	public static int[] GCD(int a, int b) {
		//in which gcd0 is the calculated x, 1 is y, 2 is gcd 
		if (b == 0) {
			int[] gcd = {1,0,a};
			return gcd;
		}
		else {
			int[] gcd = GCD(b, a%b);
			int[] retrn = {gcd[1], gcd[0] - (a/b) * gcd[1], gcd[2]};
			return retrn;
		}
		
	}

}
