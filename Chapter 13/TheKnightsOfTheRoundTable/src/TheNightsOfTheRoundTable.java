import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()) {
			String[] t = in.nextLine().split(" ");
			double a = Double.parseDouble(t[0]);
			double b = Double.parseDouble(t[1]);
			double c = Double.parseDouble(t[2]);
			
			if(a == 0 || b == 0 || c == 0) {
				System.out.print("The radius of the round table is: 0.000\n");
				continue;
			}
			
			double avg = (a+b+c)/2;
			double rad = Math.sqrt((avg-a)*(avg-b)*(avg-c)/avg);
			System.out.printf("The radius of the round table is: %.3f\n",rad);
		}
	}

}
