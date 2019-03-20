import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		ArrayList<Turtle> turts = new ArrayList<Turtle>();
		
		while(in.hasNextLine()) {
			String[] nums = in.nextLine().split(" ");
			if(Integer.parseInt(nums[0]) < Integer.parseInt(nums[1]))
				turts.add(new Turtle(Integer.parseInt(nums[0]),Integer.parseInt(nums[1])));
		}
		
		Collections.sort(turts);
		
		/*
		for(int i = 0; i < turts.size(); i++) {
			System.out.printf("%d %d \n",turts.get(i).weight,turts.get(i).strength);
		} */
		
		int[] stack = new int[turts.size() + 1];
		for(int i = 1; i < stack.length; i++)
			stack[i] = Integer.MAX_VALUE;
		int size = 0;
		
		for(int i = 0; i < turts.size(); i++) {
			for(int j = i + 1; j > 0; j--) {
				if(stack[j - 1] <= turts.get(i).strength - turts.get(i).weight) {
					if(stack[j] <= stack[j-1] + turts.get(i).weight)
						stack[j] = stack[j];
					else
						stack[j] = stack[j - 1] + turts.get(i).weight;
					
					if(stack[j] > stack[size])
						size = j;
				}
			}
		}
		
		/*
		for(int i = 0; i < stack.length; i++) {
			System.out.println(stack[i]);
		}*/
		
		System.out.print(size + "\n");
		
		
	}

}

class Turtle implements Comparable{
	int weight,strength;
	
	Turtle(int w, int s){
		weight = w;
		strength = s;
	}

	@Override
	public int compareTo(Object o) {
		Turtle t = (Turtle) o;
		
		return strength - t.strength;
	}
}
