import java.util.Scanner;

//www.voidcn.com/article/p-rawfboze-mh.html

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		/*while(in.hasNextLine()) {
			String[] tokens = in.nextLine().split(" ");
			int id = Integer.parseInt(tokens[0]);
			int cells = Integer.parseInt(tokens[1]);
			long state = Long.parseLong(tokens[2]);
			
			
		}*/
		
		for(int i = 1; i <=13; i++)
			for(int j = 1; j <=i; j++)
				for(int k = 1; k <=i; k++)
					System.out.printf("%d %d %d\n",i,j,k);
	}

}
