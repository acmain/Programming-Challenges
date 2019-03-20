import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("text.txt"));
		Scanner in = new Scanner(System.in);

		final double INF = Math.pow(10000, 2);

		while (true) {
			int num = 0;
			if (in.hasNextLine()) {
				num = Integer.parseInt(in.nextLine());
			}

			if (num == 0)
				break;

			ArrayList<Pair> p = new ArrayList<Pair>();
			for (int n = 0; in.hasNextLine() && n < num; n++) {
				String[] t = in.nextLine().split(" ");
				p.add(new Pair(Double.parseDouble(t[0]), Double.parseDouble(t[1])));
			}

			Collections.sort(p);

			double dis = INF;
			// divide and conquer algorithm from Algorithmist
			double min = Math.min(dis, divideAndConquer(p, dis, 0, p.size() - 1));
			if (min == INF)
				System.out.print("INFINITY\n");
			else
				System.out.printf("%.4f\n", Math.sqrt(min));
		}

		in.close();
	}

	public static double divideAndConquer(ArrayList<Pair> p, double dis, int l, int r) {
		if (l < r) {
			if (l + 1 == r)
				return dist(p.get(l), p.get(r));

			int m = (l + r) / 2;
			dis = Math.min(dis, divideAndConquer(p, dis, l, m));
			dis = Math.min(dis, divideAndConquer(p, dis, m + 1, r));

			double d = dis;
			for (int i = m; i >= l; i--) {
				if (Math.pow(p.get(i).x - p.get(m).x, 2) >= d)
					break;
				for (int j = m + 1; j <= r; j++) {
					if (Math.pow(p.get(i).x - p.get(j).x, 2) >= d)
						break;

					d = Math.min(d, dist(p.get(i), p.get(j)));
				}
			}

			dis = Math.min(dis, d);
			return dis;
		}
		return Double.MAX_VALUE;
	}

	public static double dist(Pair a, Pair b) {
		return (Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}

}

class Pair implements Comparable<Pair> {
	double x, y;

	Pair(double x, double y) {
		this.x = x;
		this.y = y;
	}

	void Print() {
		System.out.println(x + " " + y);
	}

	@Override
	public int compareTo(Pair p) {
		if (x == p.x) {
			if (y == p.y)
				return 0;
			else if (y > p.y)
				return 1;
			else
				return -1;

		} else if (x > p.x)
			return 1;
		else
			return -1;
	}

}
