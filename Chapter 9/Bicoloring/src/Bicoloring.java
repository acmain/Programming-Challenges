import java.util.ArrayList;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			int vertices = 0;
			if(in.hasNextLine())
				vertices = Integer.parseInt(in.nextLine());
			
			if(vertices == 0)
				break;
			
			Vertex[] v = new Vertex[vertices];
			for(int i = 0; i < vertices; i++)
				v[i] = new Vertex();
			
			int edges = 0;
			if(in.hasNextLine())
				edges = Integer.parseInt(in.nextLine());
			
			//System.out.printf("%d %d ", vertices, edges);
			
			for(int e = 0; in.hasNextLine() && e < edges; e++) {
				String[] tokens = in.nextLine().split(" ");
				v[Integer.parseInt(tokens[0])].addAdjacent(v[Integer.parseInt(tokens[1])]);
				v[Integer.parseInt(tokens[1])].addAdjacent(v[Integer.parseInt(tokens[0])]);
			}
			
			boolean bicolorable = true;
			
			for(int i = 0; i < vertices; i++) {
				if(i == 0) {
					v[i].setColor(0);
				}
				
				v[i].setAdjacentColor();
				if(!v[i].checkAdjacent())
					bicolorable = false;
			}
			
			if(bicolorable)
				System.out.print("BICOLORABLE.\n");
			else
				System.out.print("NOT BICOLORABLE.\n");
		}
	}
}

class Vertex {
	private int color; //-1 is uncolored, 0 is black, 1 is red
	private ArrayList<Vertex> adjacent = new ArrayList<Vertex>();
	
	public Vertex() {
		color = -1;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	public boolean hasColor() {
		if(color == -1)
			return false;
		else
			return true;
	}
	
	public void addAdjacent(Vertex vertex) {
		adjacent.add(vertex);
	}
	
	public void setAdjacentColor() {
		for(int i = 0; i < adjacent.size(); i++) {
			if(!adjacent.get(i).hasColor())
				adjacent.get(i).setColor((color + 1) % 2);
		}
	}
	
	public boolean checkAdjacent() {
		for(int i = 0; i < adjacent.size(); i++) {
			if(color == adjacent.get(i).getColor())
				return false;
		}
		
		return true;
	}
}
