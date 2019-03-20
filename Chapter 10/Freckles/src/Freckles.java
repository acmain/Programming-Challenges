import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = 0;
		if (in.hasNextLine())
			cases = Integer.parseInt(in.nextLine());

		for(int c = 0; c < cases; c++) {
			//blank
			in.nextLine();
			int freckles = 0;
			freckles = Integer.parseInt(in.nextLine());
			
			double[][] points = new double[freckles][2];

			for(int f = 0; f < freckles; f++) {
				String[] coords = in.nextLine().split(" ");
				
				points[f][0] = Double.parseDouble(coords[0]);
				points[f][1] = Double.parseDouble(coords[1]);
			}
			
			double[][] dists = new double[freckles][freckles];
			
			for(int i = 0; i < freckles; i++) {
				for(int j = 0; j < freckles; j++) {
					if(i == j)
						continue;
					if(dists[i][j] != 0)
						continue;
					else {
						dists[i][j] = Math.sqrt(Math.pow((points[i][0] - points[j][0]), 2) + (Math.pow((points[i][1] - points[j][1]), 2)));
						dists[j][i] = dists[i][j];
					}
				}	
			}
			
			boolean[] visited = new boolean[freckles];
			int current = 0;
			double sum = 0;
			
			ArrayList<line> queue = new ArrayList<line>();
			
			for(int i = 1; i < freckles; i++) {
				visited[current] = true;
				
				for(int j = 1; j < freckles; j++) {
					queue.add(new line(current, j, dists[current][j]));
				}
				
				Collections.sort(queue);
				
				if(!queue.isEmpty()) {
					while(visited[queue.get(0).destination]) {
						queue.remove(0);
					}
					
					sum += queue.get(0).distance;
					current = queue.get(0).destination;
				}
			}
				
			System.out.printf("%.2f\n", sum);
			if(c != cases - 1)
				System.out.print("\n");
		}
	}
}

class line implements Comparable<line>{
	int origin, destination;
	double distance;
	
	line(int o, int d, double l){
		origin = o;
		destination = d;
		distance = l;
	}

	@Override
	public int compareTo(line l) {
		if (l.distance < this.distance)
			return 1;
		else if(l.distance == this.distance)
			return 0;
		else
			return -1;
	}
}
