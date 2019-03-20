/* @JUDGE_ID: 946699 100 JAVA "Dynamic Programming" */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int[] known = new int[999999];
		int i = 0;
		int j = 0;
		String line;
		int count = 0;
		
		while(in.hasNextLine()) {
			line = in.nextLine();
			Scanner scan = new Scanner(line);
			i = scan.nextInt();
			
			if(scan.hasNextInt())
				j = scan.nextInt();
			else {
				line = in.nextLine();
				j = scan.nextInt();
			}
			
			System.out.print(i + " " + j + " ");
			
			System.out.print(maxLen(i, j, known) + "\n");
			scan.close();
			
		}
		in.close();
	}

	public static int maxLen(int i, int j, int[] known) {
		int x,y;
		if(i > j) {
			x = j;
			y = i;
		} else {
			x = i;
			y = j;
		}
		
		int max = 0;
		for(int k = x; k <= y; k++) {
			if(known[k - 1] == 0) {
				known[k - 1] = cycleLen(k);
			}
			
			if(known[k - 1] > max)
				max = known[k - 1];
		}
		
		return max;
		
	}
	
	public static int cycleLen(int x) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(x);
		
		while(x != 1)
		if(x % 2 == 0) {
			x *= 0.5;
			arr.add(x);
		}
		else {
			x = (3*x) + 1;
			arr.add(x);
		}
		
		return arr.size();
	}

}
