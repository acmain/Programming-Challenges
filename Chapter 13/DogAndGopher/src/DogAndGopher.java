import java.util.ArrayList;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int ct = 0;
		while(in.hasNextLine()) {
			if(ct != 0)
				in.nextLine();
			ct++;
			
			String[] tok = in.nextLine().split(" ");
			int n = Integer.parseInt(tok[0]);
			Coords goph = new Coords(Double.parseDouble(tok[1]), Double.parseDouble(tok[2]));
			Coords dog = new Coords(Double.parseDouble(tok[3]), Double.parseDouble(tok[4]));

			ArrayList<Coords> holes = new ArrayList<Coords>();
			for(int i = 0; i < n; i++) {
				String[] t = in.nextLine().split(" ");
				holes.add(new Coords(Double.parseDouble(t[0]), Double.parseDouble(t[1])));
			}
			
			boolean escape = false;
			int esc = -1;
			for(int i = 0; i < holes.size(); i++) {
				double dd = dist(dog,holes.get(i));
				double dg = dist(goph,holes.get(i));
				//System.out.println(dd + " " + dg);
				if(2 * dg <= dd) {
					escape = true;
					esc = i;
					break;
				}
			}
			
			if(escape)
				System.out.printf("The gopher can escape through the hole at (%.3f,%.3f).\n",holes.get(esc).x, holes.get(esc).y);
			else
				System.out.print("The gopher cannot escape.\n");
			
		}

	}
	
	public static double dist(Coords c1, Coords c2) {
		return Math.sqrt(Math.pow((c1.x-c2.x), 2) + Math.pow((c1.y-c2.y), 2));
	}

}

class Coords {
	double x,y;
	
	Coords(double x, double y){
		this.x = x;
		this.y = y;
	}
}
