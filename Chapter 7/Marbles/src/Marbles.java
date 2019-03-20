import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()) {
			long marbles = Integer.parseInt(in.nextLine());
			if(marbles == 0)
				break;
			
			String[] tokens1 = in.nextLine().split(" ");
			String[] tokens2 = in.nextLine().split(" ");
			
			long cost1 = Long.parseLong(tokens1[0]);
			long cap1 = Long.parseLong(tokens1[1]);
			long cost2 = Long.parseLong(tokens2[0]);
			long cap2 = Long.parseLong(tokens2[1]);
			long[] gcd = GCD(cap1,cap2);
			
			if(marbles % gcd[2] == 0) {
				gcd[0] *= marbles / gcd[2];
				gcd[1] *= marbles / gcd[2];
				cap1 /= gcd[2];
				cap2 /= gcd[2];
				long lower = (long) Math.ceil(-(double)gcd[0]/cap2);
				long upper = (long) Math.floor((double)gcd[1]/cap1);
			
				if(lower <= upper) {
					long minCost = cost1 * cap2 - cost2 * cap1;
					long min1,min2;
					if(minCost * lower <= minCost * upper) {
						min1 = gcd[0] + cap2 * lower;
						min2 = gcd[1] - cap1 * lower;
					} else {
						min1 = gcd[0] + cap2 * upper;
						min2 = gcd[1] - cap1 * upper;
					}
					System.out.printf("%d %d\n", min1, min2);
				} else
					System.out.print("failed\n");
			} else
				System.out.print("failed\n");
		}

	}
	
	public static long[] GCD(long a, long b) {
		//in which gcd0 is the calculated x, 1 is y, 2 is gcd 
		if (b == 0) {
			long[] gcd = {1,0,a};
			return gcd;
		}
		else {
			long[] gcd = GCD(b, a%b);
			long[] retrn = {gcd[1], gcd[0] - (a/b) * gcd[1], gcd[2]};
			return retrn;
		}
		
	}

}
