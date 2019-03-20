import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = Integer.parseInt(in.nextLine());
		
		for(int cse = 0; cse < cases; cse++) {
			if(in.hasNextLine())
				in.nextLine(); //for blank line
			
			//https://gist.github.com/I-See-You/08722b5604d94780a093
			boolean[][][][] tried = new boolean[10][10][10][10];
			boolean[][][][] forbid = new boolean[10][10][10][10];
			int[][][][] step = new int[10][10][10][10];
			int[] tok = new int[4];
			
			//get beginning
			if(in.hasNextLine())
				tok = intTokens(in.nextLine());
			Config begin = new Config(tok[0],tok[1],tok[2],tok[3]);
			
			tried[tok[0]][tok[1]][tok[2]][tok[3]] = true;
			
			//get end
			if(in.hasNextLine())
				tok = intTokens(in.nextLine());
			Config end = new Config(tok[0],tok[1],tok[2],tok[3]);
			
			//get forbidden
			int numForbid = 0;
			if(in.hasNextLine())
				numForbid = Integer.parseInt(in.nextLine());
			
			for(int f = 0; in.hasNextLine() && f < numForbid; f++) {
				tok = intTokens(in.nextLine());
				
				forbid[tok[0]][tok[1]][tok[2]][tok[3]] = true;
			}
			
			//start search
			Queue<Config> q = new LinkedList<Config>();
			q.add(begin);
			
			while(!q.isEmpty()) {
				Config current = q.peek();
				q.remove();
				
				int a = current.getL();
				int b = current.getLM();
				int c = current.getRM();
				int d = current.getR();
				int stp = step[a][b][c][d];

				
				for(int i = 0; i < 4; i++) {
					for(int j = 0; j < 3; j += 2) {
						if (i == 0) {
							if (a == 0 && j == 0)
								a = (a + j + 9) % 10;
							else
								a = (a + j - 1) % 10;
						} else if (i == 1) {
							if (b == 0 && j == 0)
								b = (b + j + 9) % 10;
							else
								b = (b + j - 1) % 10;
						} else if (i == 2) {
							if (c == 0 && j == 0)
								c = (c + j + 9) % 10;
							else
								c = (c + j - 1) % 10;
						} else {
							if (d == 0 && j == 0)
								d = (d + j + 9) % 10;
							else
								d = (d + j - 1) % 10;
						}
						
						if(!tried[a][b][c][d] && !forbid[a][b][c][d]) {
							tried[a][b][c][d] = true;
							step[a][b][c][d] = 1 + stp;
							System.out.printf("%d %d %d %d %d\n",a,b,c,d,step[a][b][c][d]);
							q.add(new Config(a,b,c,d));
						}
						
					}
				}
			}
			
			System.out.print(step[end.getL()][end.getLM()][end.getRM()][end.getR()] + "\n");
		}
		
	}
	
	public static int[] intTokens(String newLine) {
		String[] tokens = newLine.split(" ");
		//System.out.println(tokens.length);
		int[] t = new int[4];
		for(int i = 0; i < 4; i++)
			t[i] = Integer.parseInt(tokens[i]);
		
		return t;
	}
	
}

class Config {
	private int left,leftMid,rightMid,right;
	
	public Config() {
		left = 0;
		leftMid = 0;
		rightMid = 0;
		right = 0;
	}
	
	public Config(int l, int lm, int rm, int r) {
		left = l;
		leftMid = lm;
		rightMid = rm;
		right = r;
	}
	
	public int getL() { return left; }
	public int getLM() { return leftMid; }
	public int getRM() { return rightMid; }
	public int getR() { return right; }
}
