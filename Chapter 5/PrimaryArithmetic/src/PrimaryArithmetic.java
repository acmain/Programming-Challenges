import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			String line = in.nextLine();
			
			if(line.equals("0 0"))
				break;
			
			String[] intStrings = line.split(" ");
			
			int carries = numCarry(intStrings);
			
			if (carries == 0)
				System.out.print("No carry operation.\n");
			else if (carries == 1)
				System.out.print("1 carry operation.\n");
			else
				System.out.printf("%d carry operations.\n", carries);
			
		}
	}
	
	public static int numCarry(String[] intStrings) {
		int num1 = Integer.parseInt(intStrings[0]);
		int num2 = Integer.parseInt(intStrings[1]);
		int result = num1 + num2;
		int[] lengths = {String.valueOf(num1).length(), String.valueOf(num2).length(), String.valueOf(result).length()};
		
		int maxLen = 0;
		if(num1 >= num2)
			maxLen = lengths[0];
		else
			maxLen = lengths[1];
		
		int carries = 0;
		for(int i = 1; i <= maxLen; i++) {
			char char1,char2,charR;
			if(lengths[0] - i >= 0)
				char1 = String.valueOf(num1).charAt(lengths[0] - i);
			else
				char1 = '0';
			
			if(lengths[1] - i >= 0)
				char2 = String.valueOf(num2).charAt(lengths[1] - i);
			else
				char2 = '0';
			
			char higher;
			char lower;
			if(char1 > char2) {
				higher = char1;
				lower = char2;
			} else {
				higher = char2;
				lower = char1;
			}
			
			charR = String.valueOf(result).charAt(lengths[2] - i);
			//System.out.printf("%d %s %s\n", result, charR, higher); //debug
			if(charR < higher)
				carries++;
			if(charR == higher && lower != '0')
				carries++;
		}
		
		return carries;
		
	}
}
