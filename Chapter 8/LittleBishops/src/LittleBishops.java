import java.util.Scanner;

class Main {	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		

		int[][] hardCode = {
			{1},
			{4,4},
			{9,26,26,8},
			{16,92,232,260,112,16},
			{25,240,1124,2728,3368,1960,440,32},
			{36,520,3896,16428,39680,53744,38368,12944,1600,64},
			{49,994,10894,70792,282248,692320,1022320,867328,389312,81184,5792,128},
			{64,1736,26192,242856,1444928,5599888,14082528,22522960,22057472,12448832,3672448,489536,20224,256}
		};
		
		int[][] possibleVals = new int[8][64];
		
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < hardCode[i].length; j++)
				possibleVals[i][j] = hardCode[i][j];
		
		while(in.hasNextLine()) {
			String[] tokens = in.nextLine().split(" ");
			int size = Integer.parseInt(tokens[0]);
			int bishops = Integer.parseInt(tokens[1]);
			
			if(size == 0)
				break;
			
			if(bishops == 0)
				System.out.print("1\n");
			else
				System.out.println(possibleVals[size-1][bishops-1]);
		}
	}
}