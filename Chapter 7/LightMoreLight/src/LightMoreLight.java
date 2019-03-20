import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()) {
			long input = Long.parseLong(in.nextLine());
			
			if(input == 0)
				break;
			
			//only yes if perfect square.
			double sqrt = Math.sqrt(input);
			
			if((int) sqrt - sqrt == 0)
				System.out.print("yes\n");
			else
				System.out.print("no\n");
			
			
		}
	}

}
