import java.util.ArrayList;
import java.util.Scanner;

class Main {

	static ArrayList<Country> countries = new ArrayList<Country>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numC = 0;
		if (in.hasNextLine())
			numC = Integer.parseInt(in.nextLine());

		Country.numCountries = numC;

		for (int i = 0; i < numC; i++)
			countries.add(new Country(i));

		while (in.hasNextLine()) {
			int op, c1, c2;
			String[] tokens = in.nextLine().split(" ");

			op = Integer.parseInt(tokens[0]);
			c1 = Integer.parseInt(tokens[1]);
			c2 = Integer.parseInt(tokens[2]);

			if (op == 0 && c1 == 0 && c2 == 0) {
				break;
			} else if (op == 1) {

			} else if (op == 2) {

			} else if (op == 3) {
				if (areFriends(c1, c2,countries))
					System.out.print("1");
				else
					System.out.print("0");

			} else {
				if (areEnemies(c1, c2, countries))
					System.out.print("1");
				else
					System.out.print("0");
			}

		}

		in.close();
	}

	public static boolean setFriends(int x, int y, ArrayList<Country> a) {
		//case both alleg -1
		if(areEnemies(x,y,a))
			return false;
		
		//case both alleg 1
		if(areFriends(x,y,a)) {
			return true;
		}
		
		ArrayList<Country> copy = countries;
		//case both are 0
		if(conflicts(x,y))
			return false;
		else {
			copy.get(x).allegiance = union(countries.get(x).allegiance, countries.get(y).allegiance);
			copy.get(y).allegiance = copy.get(x).allegiance;
			for(int i = 0; i < Country.numCountries; i++) {
				if(a.get(x).allegiance[i] == -1 && a.get(x).allegiance[i] == -1)
					setFriends()
			}
		}
		
		return true;
	}

	public static void setEnemies(int x, int y, ArrayList<Country> a) {

	}

	public static boolean areFriends(int x, int y, ArrayList<Country> a) {
		if (a.get(x).allegiance[y] == 1)
			return true;
		else
			return false;
	}

	public static boolean areEnemies(int x, int y, ArrayList<Country> a) {
		if (a.get(x).allegiance[y] == -1)
			return true;
		else
			return false;
	}
	
	public static boolean conflicts(int x, int y) {
		
		for(int i = 0; i < Country.numCountries; i++) {
			if (countries.get(x).allegiance[i] == 1 && countries.get(y).allegiance[i] == -1)
				return true; //my friend is their enemy or their enemy is my friend
			if (countries.get(y).allegiance[i] == 1 && countries.get(x).allegiance[i] == -1)
				return true;

		}
		return false;
	}
	
	public static int[] union(int[] x, int[] y) {
		int[] temp = new int[Country.numCountries];
		for(int i = 0; i < Country.numCountries; i++) {
			if(x[i] == 1 || y[i] == 1)
				temp[i] = 1;
			else if(x[i] == -1 || y[i] == -1)
				temp[i] = -1;
			else temp[i] = 0;
		}
		
		return temp;
	}
}

class Country {
	int name;
	static int numCountries;
	int[] allegiance; // -1 enemy, 0 neutral, 1 friend

	Country(int name) {
		this.name = name;
		allegiance = new int[numCountries];
		allegiance[name] = 1; // friend of yourself
	}
}
