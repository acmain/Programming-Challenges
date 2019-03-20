import java.util.Scanner;

class Main {
	static double height = 0.5 * Math.sqrt(3);
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			String[] houseTok = in.nextLine().split(" ");
			int h1 = Integer.parseInt(houseTok[0]);
			int h2 = Integer.parseInt(houseTok[1]);
			
			Coords house1 = process(h1);
			Coords house2 = process(h2);
			
			double dist = Math.sqrt(Math.pow(house1.x-house2.x, 2) + Math.pow(house1.y-house2.y, 2));
			
			System.out.printf("%.3f\n",dist);
			
		}
			
	}
		
	public static Coords process(int h) {
		double row =  (int) Math.sqrt(h);
		int r = (int) row;
		int rowDif = (int) Math.abs(r*r - ((r+1)*(r+1) - 1));
		
		//we know that the peak is 0,0
		//1s is -1,-1

		
		//so for 9 or 10
		//row = 3
		//for 9 col = -3 for 10 col = -2.5
		//dif = 6, row+1 points on the row
		
		//even rows
		//row = 2
		//4 = -1, 2
		//5 = -.5,2
		//6 = 0,2
		//7 = .5,2
		int median = (int) (rowDif/2 + row*row);
		double column = 0;
			if(h == median)
				column = 0;
			else if(h < median) {
				for(int i = 0; i < median-h; i++) {
					column -= .5;
					//System.out.println(i + " " + (median-h));
				}
			}
			else {
				for(int i = 0; i < h-median; i++) {
					column += .5;
					//System.out.println(i + " " + (h-median));
				}
			}
			row *= height;
			if(r % 2 == 0) {
				if(h % 2 == 0) {
					row += height*2/3;
				}
				else {
					row += height/3;
				}
			}
			else {
				if(h%2 == 0) {
					row += height/3;
				}
				else {
					row += height*2/3;
				}
			}
			
			//System.out.println(row + " " + column);
			return new Coords(row,column);
		
		//center = 2/3 * h;
	}

}

class Coords {
	double x;
	double y;
	
	Coords() {
		this.x = 0;
		this.y = 0;
	}
	
	Coords(double x, double y){
		this.x = x;
		this.y = y;
	}
}


