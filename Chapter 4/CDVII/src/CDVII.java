import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("text.txt"));
		Scanner in = new Scanner(System.in);

		int cases = 0;
		if (in.hasNextLine())
			cases = Integer.parseInt(in.nextLine());
		in.nextLine(); // blank

		for (int c = 0; in.hasNextLine() && c < cases; c++) {
			String[] t = in.nextLine().split(" ");
			int[] fares = new int[24];
			for (int i = 0; i < 24; i++) {
				fares[i] = Integer.parseInt(t[i]);
			}

			String line;
			if (in.hasNextLine())
				line = in.nextLine();
			else
				break;

			ArrayList<Car> cars = new ArrayList<Car>();

			while (!(line.equals(""))) {
				String[] l = line.split(" ");

				// get plate num
				int carIndex = -1;
				if (cars.size() == 0) {
					cars.add(new Car(l[0], fares));
					carIndex = 0;
				} else {
					for (int i = 0; i < cars.size(); i++) {
						if ((cars.get(i).plate).equals(l[0])) {
							carIndex = i;
							break;
						}
					}
					if (carIndex == -1) {
						cars.add(new Car(l[0], fares));
						carIndex = cars.size() - 1;
					}
				}

				// process photos
				if (l[2].equals("enter")) {
					cars.get(carIndex).in.add(new Photo(l[1], Integer.parseInt(l[3])));
				} else if (l[2].equals("exit")) {
					cars.get(carIndex).out.add(new Photo(l[1], Integer.parseInt(l[3])));
				}

				if (in.hasNextLine())
					line = in.nextLine();
				else
					line = "";
			}

			// for(int i = 0; i < cars.size(); i++)
			// cars.get(i).print();

			// calculate
			Collections.sort(cars);

			for (int i = 0; i < cars.size(); i++) {
				if (cars.get(i).trips() != 0) {
					cars.get(i).calc();
					if (cars.get(i).tot != 0)
						System.out.printf("%s $%.2f\n", cars.get(i).plate, cars.get(i).tot);
				}
			}
			if (c != cases - 1)
				System.out.print("\n");

		}
	}

}

class Car implements Comparable<Car> {
	String plate;
	int[] fares;
	double tot;
	int trips;
	Comparator<Photo> comp = new TimeComp();
	Queue<Photo> in = new PriorityQueue<Photo>(comp);
	Queue<Photo> out = new PriorityQueue<Photo>(comp);
	ArrayList<Integer> tripCosts = new ArrayList<Integer>();

	Car(String plate, int[] f) {
		this.plate = plate;
		fares = f;
		trips = 0;
	}

	int trips() {
		// System.out.println("in: " + in.size() + " out: " + out.size());
		return Math.min(in.size(), out.size());
	}

	boolean hasTrips() {
		if (trips() == 0)
			return false;
		else
			return true;
	}

	void calc() {
		double rtn = 0;
		int ins = in.size(), outs = out.size();
		while (!in.isEmpty() && !out.isEmpty()) {
			Photo p1 = in.poll();

			Photo p2 = out.poll();
			while (p2.before(p1) && !out.isEmpty()) {
				p2 = out.poll();
			}

			while (!in.isEmpty() && in.peek().before(p2)) {
				p1 = in.poll();
			}

			if (p1.before(p2)) {
				trips++;
				double temp;

				temp = (fares[p1.h] * Math.abs(p2.marker - p1.marker)) / 100.0;
				// System.out.println(fares[p1.h] + " " + p2.marker + " " + p1.marker + " " +
				// temp);
				if (temp > 0)
					rtn += temp;
			}
		}

		rtn += trips;
		if (trips != 0)
			rtn += 2;

		tot = rtn;
	}

	@Override
	public int compareTo(Car c) {
		return this.plate.compareTo(c.plate);
	}

	void print() {
		System.out.println("Plate: " + plate);
		System.out.println("Trips: " + trips());
		while (!in.isEmpty()) {
			System.out.print("In: ");
			in.poll().print();
		}
		while (!out.isEmpty()) {
			System.out.print("Out: ");
			out.poll().print();
		}
	}
}

class Photo {
	int mon, d, h, m;
	int marker;

	Photo(String s, int mar) {
		String[] t = s.split(":");
		mon = Integer.parseInt(t[0]);
		d = Integer.parseInt(t[1]);
		h = Integer.parseInt(t[2]);
		m = Integer.parseInt(t[3]);
		marker = mar;
	}

	boolean before(Photo p) {
		int a = m + h * 60 + d * 60 * 24;
		int b = p.m + p.h * 60 + p.d * 60 * 24;

		if (a < b)
			return true;
		else
			return false;
	}

	void print() {
		System.out.printf("%d:%d:%d:%d %d\n", mon, d, h, m, marker);
	}
}

class TimeComp implements Comparator<Photo> {

	@Override
	public int compare(Photo p1, Photo p2) {
		int rtn;

		rtn = p1.d - p2.d;

		if (rtn == 0)
			rtn = p1.h - p2.h;

		if (rtn == 0)
			rtn = p1.m - p2.m;

		if (rtn < 0)
			return -1;
		else if (rtn > 0)
			return 1;
		else
			return 0;
	}

}
