import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			boolean poss = true;

			String[] nums = in.nextLine().split(" ");
			int numTeams = Integer.parseInt(nums[0]);
			int numTables = Integer.parseInt(nums[1]);

			if (numTables == 0 || numTeams == 0) {
				break;
			}

			int[] teams = new int[numTeams];
			String[] teamCaps = in.nextLine().split(" ");
			for (int t = 0; poss && t < numTeams; t++) {
				teams[t] = Integer.parseInt(teamCaps[t]);
				if (teams[t] > numTables) {
					poss = false;
				}
			}

			int[][] teamTabs = new int[numTeams][numTables];

			ArrayList<Table> tables = new ArrayList<Table>();
			String[] tableCaps = in.nextLine().split(" ");
			for (int t = 0; poss && t < numTables; t++) {
				tables.add(new Table(t + 1, Integer.parseInt(tableCaps[t])));
			}

			// place at tables
			for (int i = 0; poss && i < numTeams; i++) {
				Collections.sort(tables);
				for (int j = 0; j < teams[i]; j++) {
					if (tables.get(j).getCapacity() < 1) {
						poss = false;
					}
					teamTabs[i][j] = tables.get(j).getNumber();
					tables.get(j).decrement();
				}
			}

			if (poss) {
				System.out.print("1\n");
				for (int i = 0; i < numTeams; i++) {
					for (int j = 0; j < teams[i]; j++) {
						if (j != teams[i] - 1)
							System.out.print(teamTabs[i][j] + " ");
						else
							System.out.print(teamTabs[i][j] + "\n");
					}
				}
			} else {
				System.out.print("0\n");
			}
		}
	}
}

class Table implements Comparable<Table> {
	int number;
	int capacity;

	Table(int n, int c) {
		number = n;
		capacity = c;
	}

	int getNumber() {
		return number;
	}

	int getCapacity() {
		return capacity;
	}

	void decrement() {
		capacity -= 1;
	}

	@Override
	public int compareTo(Table t) {
		return (int) (t.getCapacity() - this.capacity);
	}
}
