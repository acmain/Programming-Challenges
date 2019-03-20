import java.math.BigInteger;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = 0;
		while(in.hasNextLine() && count <= 100) {
			count++;
			int len = Integer.parseInt(in.nextLine());
			BigInteger l = new BigInteger(String.valueOf(len));
			long con = (long) ((Math.pow(len, 2) + len)/2);
			BigInteger c = new BigInteger(String.valueOf(con));
			BigInteger s2,r2,s3,r3,s4,r4;
			s2=r2=s3=r3=s4=r4=BigInteger.ZERO;
			
			s2 = s2.add((l.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE)).multiply(c).divide(BigInteger.valueOf(3)));
			s3 = s3.add(c.multiply(c));
			s4 = s4.add((c.multiply((l.multiply(l).multiply(l).multiply(BigInteger.valueOf(6))).add(l.multiply(l).multiply(BigInteger.valueOf(9)).add(l).subtract(BigInteger.ONE)))).divide(BigInteger.valueOf(15)));
			r2 = r2.add(s3.subtract(s2));
			r3 = r3.add(s3.multiply(c.subtract(BigInteger.ONE)));
			r4 = r4.add(s3.multiply(s3).subtract(s4));
			
			//System.out.printf("%f %f %f %f %f %f", s2,r2,s3,r3,s4,r4);
			System.out.printf("%d %d %d %d %d %d\n", s2,r2,s3,r3,s4,r4);
		}

	}
	
}
