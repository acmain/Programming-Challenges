import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class Main {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner in = new Scanner(new File("text.txt"));
		//Scanner in = new Scanner(System.in);
		int tournaments = 0;
		if (in.hasNextLine())
			tournaments = Integer.parseInt(in.nextLine());

		for (int t = 0; in.hasNextLine() && t < tournaments; t++) {
			String tourney = in.nextLine();
			int numTeams = 0;
			if (in.hasNextLine())
				numTeams = Integer.parseInt(in.nextLine());

			List<Team> teams = new ArrayList<Team>();

			for (int i = 0; in.hasNextLine() && i < numTeams; i++) {
				teams.add(new Team(in.nextLine()));
			}

			int numGames = 0;
			if (in.hasNextLine())
				numGames = Integer.parseInt(in.nextLine());

			for (int i = 0; in.hasNextLine() && i < numGames; i++) {
				String game = in.nextLine();
				String[] tokens = game.split("#|@");

				// process left side
				for (int j = 0; j < numTeams; j++) {
					if (tokens[0].equals(teams.get(j).getName())) {
						teams.get(j).addGoalsScored(Integer.parseInt(tokens[1]));
						teams.get(j).addGoalsAgainst(Integer.parseInt(tokens[2]));
						if (Integer.parseInt(tokens[1]) > Integer.parseInt(tokens[2]))
							teams.get(j).addWin();
						else if (Integer.parseInt(tokens[1]) == Integer.parseInt(tokens[2]))
							teams.get(j).addDraw();
						else
							teams.get(j).addLoss();
						break;
					}
				}
				// process right side
				for (int j = 0; j < numTeams; j++) {
					if (tokens[3].equals(teams.get(j).getName())) {
						teams.get(j).addGoalsScored(Integer.parseInt(tokens[2]));
						teams.get(j).addGoalsAgainst(Integer.parseInt(tokens[1]));
						if (Integer.parseInt(tokens[2]) > Integer.parseInt(tokens[1]))
							teams.get(j).addWin();
						else if (Integer.parseInt(tokens[1]) == Integer.parseInt(tokens[2]))
							teams.get(j).addDraw();
						else
							teams.get(j).addLoss();
						break;
					}
				}
			}

			// sort teams
			Collections.sort(teams, new Team());

			// output results
			System.out.print(tourney + "\n");
			for (int i = 0; i < numTeams; i++) {
				Team team = teams.get(i);
				
				System.out.printf("%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)\n", i + 1, team.getName(), team.getPoints(),
						team.getGames(), team.getWins(), team.getDraws(), team.getLosses(), team.getDifference(),
						team.getGoalsScored(), team.getGoalsAgainst());
			}

			if (t != tournaments - 1)
				System.out.print("\n");
		}

	}
}

class Team implements Comparator<Team> {
	String name;
	int wins;
	int draws;
	int losses;
	int games;
	int goalsScored;
	int goalsAgainst;
	boolean sorted;

	public Team() {

	}

	public Team(String name) {
		this.name = name;
		wins = draws = losses = games = goalsScored = goalsAgainst = 0;
		sorted = false;
	}

	public String getName() {
		return name;
	}

	public int getWins() {
		return wins;
	}

	public void addWin() {
		wins++;
	}

	public int getDraws() {
		return draws;
	}

	public void addDraw() {
		draws++;
	}

	public int getLosses() {
		return losses;
	}

	public void addLoss() {
		losses++;
	}

	public int getPoints() {
		return (3 * wins) + draws;
	}

	public int getGames() {
		return wins + draws + losses;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public void addGoalsScored(int goalsScored) {
		this.goalsScored += goalsScored;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void addGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst += goalsAgainst;
	}

	public int getDifference() {
		return goalsScored - goalsAgainst;
	}

	public void setSorted() {
		sorted = true;
	}

	public boolean getSorted() {
		return sorted;
	}

	@Override
	public int compare(Team team, Team team1) {
		int result = team1.getPoints() - team.getPoints();
		if (result == 0)
			result = team1.getWins() - team.getWins();
		if (result == 0)
			result = team1.getDifference() - team.getDifference();
		if (result == 0)
			result = team1.getGoalsScored() - team.getGoalsScored();
		if (result == 0)
			result = team.getGames() - team1.getGames();
		if (result == 0)
			result = team.getName().toLowerCase().compareTo(team1.getName().toLowerCase());

		if (result < 0)
			return -1;
		else if (result > 0)
			return 1;
		else
			return 0;
		}

}