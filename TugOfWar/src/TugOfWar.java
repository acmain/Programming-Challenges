import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/*
class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int cases = 0;
		if (in.hasNextLine())
			cases = Integer.parseInt(in.nextLine());

		for (int c = 0; in.hasNextLine() && c < cases; c++) {
			in.nextLine(); // gets rid of line between cases
			int people = 0;
			if (in.hasNextLine())
				people = Integer.parseInt(in.nextLine());
			int[] weights = new int[people];
			int sum = 0;
			for (int p = 0; in.hasNextLine() && p < people; p++) {
				weights[p] = Integer.parseInt(in.nextLine());
				sum += weights[p];
			}

			final int maxWeight = sum / 2;
			int maxPeople = (int) Math.ceil(people / 2);
			//if(people % 2 == 0)
				//maxPeople--;
			Arrays.sort(weights);

			if(people % 2 == 0) {
				boolean doubles = true;
				for(int i = 0; i < people - 1; i += 2) {
					if(weights[i] != weights[i + 1]) {
						doubles = false;
						break;
					}
				}
				if(doubles) {
					System.out.printf("%d %d\n", maxWeight, maxWeight);
					continue;
				}
				
			}
			
			int totWeight = 0, totPeople = 0;
			for (int w = people - 1; totPeople <= maxPeople && w >= 0; w--) {
				if (totWeight + weights[w] <= maxWeight) {
					totWeight += weights[w];
					totPeople++;
					System.out.printf("A: %d %d %d %d\n", sum - totWeight, totWeight, totPeople, maxPeople); // debug
				}
			}
			//if(people % 2 == 0 && totPeople < maxPeople)
				//maxPeople++;
			
			if (totPeople < maxPeople) {
				for (int w = 0; w < people; w++) {
					if (totPeople != maxPeople) {
						totWeight += weights[w];
						totPeople++;
						System.out.printf("B: %d %d %d %d\n", sum - totWeight, totWeight, totPeople, maxPeople); // debug
					} else
						break;
				}
			}

			if(totWeight > maxWeight)
				System.out.printf("%d %d\n", sum - totWeight, totWeight);
			else
				System.out.printf("%d %d\n", totWeight, sum - totWeight);

			// from here do "binary addition"
			// https://www.quora.com/How-do-I-solve-the-UVa-10032-tug-of-war-problem
			// if you forget.

			/*
			 * if(people == 0) { System.out.print("0 0\n"); } else if(people == 1) {
			 * System.out.printf("0 %d\n", weights[0]); } else { int sum1 = weights[people -
			 * 1]; int sum2 = weights[people - 2]; int sum1Count = 1, sum2Count = 1; int
			 * lowIndex = -1, highIndex = people - 2;
			 * 
			 * while(sum1Count + sum2Count != people) { if(sum1Count == sum2Count) { if(sum1
			 * < sum2) { sum1 += weights[--highIndex]; sum1Count++; } else if (sum2 < sum1)
			 * { sum2 += weights[--highIndex]; sum2Count++; } else { sum1 +=
			 * weights[++lowIndex]; sum1Count++; } } else { if (sum1Count <= sum2Count) {
			 * if(sum1 < sum2) { sum1 += weights[--highIndex]; sum1Count++; } else { sum1 +=
			 * weights[++lowIndex]; sum1Count++; } } else { if(sum2 < sum1) { sum2 +=
			 * weights[--highIndex]; sum2Count++; } else { sum2 += weights[++lowIndex];
			 * sum2Count++; } } } //System.out.printf("%d %d\n", sum1, sum2); //debug
			 * 
			 * }
			 * 
			 * if(sum1 <= sum2) System.out.printf("%d %d\n", sum1, sum2); else
			 * System.out.printf("%d %d\n", sum2, sum1);
			 * 
			 * }
			 

			if (c != cases - 1)
				System.out.print("\n");
		}

	}

}*/
