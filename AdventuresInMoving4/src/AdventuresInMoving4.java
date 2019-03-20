import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = 0;
		if(in.hasNextLine())
			cases = Integer.parseInt(in.nextLine());
		
		in.nextLine(); //blank line
		
		for(int c = 0; in.hasNextLine() && c < cases; c++) {
			ArrayList<Station> s = new ArrayList<Station>();
			boolean eoc = false;
			int dist = 0;
			if(in.hasNextLine())
				dist = Integer.parseInt(in.nextLine());
			
			s.add(new Station(0, 0));
			while(in.hasNextLine() && !eoc) {
				String line = in.nextLine();
				
				if(line.equals("")) {
					eoc = true;
				}
				
				if(!eoc) {
					String[] t = line.split(" ");
					s.add(new Station(Integer.parseInt(t[0]),Integer.parseInt(t[1])));
				}
				
			}
			
			s.add(new Station(dist,Integer.MAX_VALUE));
			
			int[][] money = new int[s.size()][s.size() * 2];
			
			for(int i = 0; i < money.length; i++)
				Arrays.fill(money[i], Integer.MAX_VALUE);
			money[0][s.size()] = 0;
			
			for(int i = 1; i <= s.size() + 1; i++) {
				/*int diff = s.get(i).dist - s.get(i-1).dist;
				for(int j = diff; j <= s.size() * 2 - 1; j++)
					money[i][j-diff] = Math.min(money[i][j-diff], money[i-1][j]);
				for(int j = 1; j <= s.size() * 2 - 1; j++)
					money[i][j] = Math.min(money[i][j], money[i][j-1] + s.get(i).price);
				*/
				for(int j = 0; j <= s.size * 2; j++) {
					for()
				}
			}
			
			int minMon = Integer.MAX_VALUE;
			for(int i = s.size(); i <= s.size() * 2 - 1; i++)
				minMon = Math.min(minMon, money[s.size()][i]);
			
			if(minMon == Integer.MAX_VALUE)
				System.out.print("Impossible\n");
			else
				System.out.print(minMon + "\n");
			
			if(c != cases - 1) {
				System.out.print("\n");
			}
		}
		
	}

}

class Station {
	int dist, price;
	Station(int d, int p){
		dist = d;
		price = p;
	}
}
