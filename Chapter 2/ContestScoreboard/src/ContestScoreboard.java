import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* @JUDGE_ID: 946699 10258 JAVA "Dynamic Programming" */

class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int scenarios = 0;

		if (in.hasNextLine())
			scenarios = Integer.parseInt(in.nextLine());

		String line = "_";
		for (int z = 0; z < scenarios; z++) {
			if(z != 0) {
				System.out.print("\n");
			}
			ArrayList<team> teams = new ArrayList<team>();
			for (int i = 0; i < 100; i++)
				teams.add(new team(i + 1));
			if (line.equals("_") && in.hasNextLine())
				line = in.nextLine();
			while (in.hasNextLine()) {
				line = in.nextLine();
				if (line.equals("") && z != 0) {
					//System.out.print("\n");
					break;
				} else if (line.equals(""))
					break;
				Scanner scan = new Scanner(line);

				int team = scan.nextInt();
				int problem = scan.nextInt();
				int time = scan.nextInt();
				char result = scan.next().charAt(0);

				if (result == 'R' || result == 'U' || result == 'E') {
					teams.get(team - 1).addTime(0);
				} else if (result == 'I' && !(teams.get(team - 1).getProbSolved(problem - 1))) {
					teams.get(team - 1).addNumWrong(problem - 1);
					teams.get(team - 1).addTime(0);
				} else if (result == 'C' && !(teams.get(team - 1).getProbSolved(problem - 1))) {
					teams.get(team - 1).addTime(time);
					teams.get(team - 1).addProbSolved(problem - 1);
					teams.get(team - 1).addSolved();
				}

				scan.close();
			}

			for (int i = 0;i < 100; i++) {
				int wrong = teams.get(i).getNumWrong();
				if(wrong > 0)
					teams.get(i).addTime(20 * wrong);
			}

			for (int i = 9; i >= 0; i--) {
				for (int j = 0; j < 100; j++) {
					int min = 1000000;
					int minIndex = 100;
					for (int k = 0; i > 0 && k < 100; k++) {
						if (teams.get(k).getSolved() == i && teams.get(k).getTime() < min
								&& !(teams.get(k).getSorted())) {
							min = teams.get(k).getTime();
							minIndex = k;
						}
					}
					if (i == 0 && teams.get(j).getSubmission() && teams.get(j).getSolved() == i) {
						teams.get(j).print();
					}

					if (minIndex != 100) {
						teams.get(minIndex).print();
						teams.get(minIndex).setSorted();
					}
				}
			}

		}
		

	}
}

class team {
	int number;
	int solved;
	int time;
	int[] numWrong = new int[9];
	boolean[] probSolv = new boolean[9];
	boolean submission;
	boolean sorted;

	team(int number) {
		this.number = number;
		solved = 0;
		time = 0;
		submission = false;
		sorted = false;
	}

	boolean getSorted() {
		return sorted;
	}

	int getNumber() {
		return number;
	}

	int getSolved() {
		return solved;
	}

	int getTime() {
		return time;
	}

	int getNumWrong() {
		int num = 0;
		for(int i = 0; i < 9; i++)
			if(probSolv[i])
				num += numWrong[i];
		
		return num;
	}

	boolean getSubmission() {
		return submission;
	};

	void addSolved() {
		this.solved++;
	}
	
	void addProbSolved(int prob) {
		probSolv[prob] = true;
	}
	
	boolean getProbSolved(int prob) {
		return probSolv[prob];
	}

	void addNumWrong(int prob) {
		this.numWrong[prob]++;
	}

	void addTime(int time) {
		this.time += time;
		submission = true;
	}

	void setSorted() {
		sorted = true;
	}

	void print() {
		System.out.printf("%d %d %d\n", number, solved, time);
	}

}
