
/* @JUDGE_ID: 946699 10252 JAVA "Dynamic Programming" */
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int loops = 0;
		String lineA;
		String lineB;
		int[] countCharA = new int[26];
		int[] countCharB = new int[26];
		int[] sameCount = new int[26];

		while (in.hasNextLine()) {
			loops++;

			if (loops % 2 == 1) {
				//first line of input pair
				lineA = in.nextLine();
				countCharA = count(lineA);
			} else {
				//second line of input pair
				lineB = in.nextLine();
				countCharB = count(lineB);
				
				//process lines pair
				sameCount = compare(countCharA, countCharB);
				for(int i = 0; i < 26; i++) {
					int numPrint = sameCount[i];
					for(int j = 0; numPrint != 0 && j < numPrint; j++)
						System.out.print((char)(i + 97));
				}
				System.out.print("\n");
			}

		}

	}
	
	public static int[] count(String line) {
		int[] count = new int[26];
		for(int i = 0; i < line.length(); i++) {
			//97 == 'a'
			count[line.charAt(i) - 97]++;
		}
		
		return count;
	}
	
	public static int[] compare(int[] a, int[] b) {
		int[] compare = new int[26];
		int min;
		for(int i = 0; i < 26; i++) {
			if(a[i] <= b[i])
				min = a[i];
			else
				min = b[i];
			
			compare[i] = min;
		}
		
		return compare;
	}

}
