import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int scenario = 0;
		
		while (true) {
			scenario++;
			int cities = 0;
			int roads = 0;
			
			String[] nums = new String[2];
			if (in.hasNextLine())
				nums = in.nextLine().split(" ");
			
			cities = Integer.parseInt(nums[0]);
			roads = Integer.parseInt(nums[1]);

			if (roads == 0 && cities == 0)
				break;
			
			double[][] priceMap = new double[cities + 1][cities + 1];
			int city1 = 0, city2 = 0, cost = 0;
			double tourists = 0;
			String[] tokens = new String[3];
			for(int n = 0; in.hasNextLine() && n < roads; n++) {
				tokens = in.nextLine().split(" ");
				city1 = Integer.parseInt(tokens[0]);
				city2 = Integer.parseInt(tokens[1]);
				cost = Integer.parseInt(tokens[2]);
				priceMap[city1][city2] = priceMap[city2][city1] = cost;
				
				for(int i = 1; i <= cities; i++) {
					for(int j = 1; j <= cities; j++) {
						for(int k = 1; k <= cities; k++) {
							priceMap[j][k] = Math.max(priceMap[j][k], Math.min(priceMap[j][i], priceMap[i][k]));
						}
					}
				}
			}
			
			if(in.hasNextLine()) {
				tokens = in.nextLine().split(" ");
				city1 = Integer.parseInt(tokens[0]);
				city2 = Integer.parseInt(tokens[1]);
				tourists = Double.parseDouble(tokens[2]);
			}
			
			int trips = (int) Math.ceil(tourists/(priceMap[city1][city2]));
			System.out.printf("Scenario #%d\nMinimum Number of Trips =  %d\n\n", scenario, trips);
		}
	}

}
