import java.math.BigInteger;
import java.util.Scanner;

class Main{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = 0;
		if(in.hasNextLine())
			cases = Integer.parseInt(in.nextLine());
		
		for(int c = 0; in.hasNextLine() && c < cases; c++) {
			BigInteger input = new BigInteger(in.nextLine());

			//long output = (1/24)*(input-3)*(input-2)*(input-1)*input - (1/2)*(input - 1)*input + 1;
			BigInteger nMinus3 = input.subtract(new BigInteger("3"));
			BigInteger nMinus2 = input.subtract(new BigInteger("2"));
			BigInteger nMinus1 = input.subtract(new BigInteger("1"));
			BigInteger twentyfour = new BigInteger("24");
			BigInteger two = new BigInteger("2");
			BigInteger output = ((nMinus3.multiply(nMinus2.multiply(nMinus1.multiply(input)))).divide(twentyfour)).add((input.multiply(nMinus1)).divide(two)).add(new BigInteger("1"));
			
			
			System.out.print(output + "\n");
		}
		
	}

}
