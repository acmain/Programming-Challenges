import java.math.BigInteger;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = 0;
		if(in.hasNextLine()) {
			cases = Integer.parseInt(in.nextLine());
		}
		
		for(int c = 0; c < cases; c++) {
			String x = "", z = "", xSimp = "";
			
			if(in.hasNextLine())
				x = in.nextLine();
			if(in.hasNextLine())
				z = in.nextLine();			
			
			for(int i = 0; i < x.length(); i++) {
				for(int j = 0; j < z.length(); j++) {
					if(x.charAt(i) == z.charAt(j)) {
						xSimp += x.charAt(i);
						break;
					}
				}
			}
			
			BigInteger num[][] = new BigInteger[xSimp.length()+1][z.length()+1];

			
			//System.out.println(xSimp.length() + " " + z.length());
			//System.out.println(xSimp);
			
			for(int i = 0; i <= xSimp.length();i++)
				num[i][0] = BigInteger.valueOf(1);
			
			for(int i = 0; i <= z.length(); i++)
				num[0][i] = BigInteger.valueOf(0);
			
			for(int i = 1; i <= z.length(); i++) {
				for(int j = 1; j <= xSimp.length(); j++) {
					num[j][i] = num[j-1][i];
					if(xSimp.charAt(j-1) == z.charAt(i-1))
						num[j][i] = num[j][i].add(num[j-1][i-1]);
				}
			}
			
			System.out.print(num[xSimp.length()][z.length()] + "\n");
			
		}

	}

}
