import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = 0;
		if(in.hasNextLine())
			cases = Integer.parseInt(in.nextLine());
		
		for(int c = 0; in.hasNextLine() && c < cases; c++) {
			Long num = Long.parseLong(in.nextLine());
			
			boolean loop = true;
			int loops = 0;
			long result = 0;
			
			while(loop) {
				loops++;
				result = num + reverse(num);
				if(result == reverse(result))
					loop = false;
				else
					num = result;
			}
			
			System.out.printf("%d %d\n",loops,result);
		}

	}
	
	static long reverse(long num) {
		String numString = String.valueOf(num);
		String reversed =  "";
		for(int i = numString.length() - 1; i >= 0; i--) {
			reversed += numString.charAt(i);
		}
		
		return Long.parseLong(reversed);
	}

}
