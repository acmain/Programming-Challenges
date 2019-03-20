/* @JUDGE_ID: 946699 10038 JAVA "Dynamic Programming" */

import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] difference;
		
		while (in.hasNextLine()) {
			String line = in.nextLine();
			difference = processLine(line);
			
			if(difference == null) {
				System.out.println("Null difference error");
			} else {
				boolean isJolly = true;
				int size = difference.length;
				Arrays.sort(difference);
				
				/* shows difference between inptus
				System.out.printf("%d ", size);
				for(int i = 0; i < size; i++)
					System.out.printf("%d ", difference[i]);
				*/
				
				if(size != 1 && difference[0] == 1 && difference[size - 1] == size) {
					for(int i = 1; i < size && isJolly == true; i++) {
						if(difference[i] - 1 != difference[i - 1])
							isJolly = false;
					}
				} else if(size != 1 && (difference[0] != 1 || difference[size - 1] != size)) {
					isJolly = false;
				} else if(size == 1 && difference[0] != 1)
					isJolly = false;
				
				if(isJolly)
					System.out.print("Jolly\n");
				else
					System.out.print("Not jolly\n");
			}

		}

		in.close();
	}
	
	public static int[] processLine(String line) {
		//process line and return array of differences
		Scanner scan = new Scanner(line);

		int num,numOld;
		if (scan.hasNextInt()) {
			numOld = num = scan.nextInt();
			if(num == 1)
				num++;
			int[] numbers = new int[num];
			int[] diff = new int[num - 1];
			
			if(numOld == 1)
				num--;

			if (num == 1)
				diff[0] = 1;
			else {
				for (int i = 0; i < num && scan.hasNextInt(); i++) {
					numbers[i] = scan.nextInt();
				}

				for (int i = 1; i < num; i++)
					diff[i - 1] = Math.abs(numbers[i] - numbers[i - 1]);
			}			
			return diff;
		}
		return null;
	}

}
