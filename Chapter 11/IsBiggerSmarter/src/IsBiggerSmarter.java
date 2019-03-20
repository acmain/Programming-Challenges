import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		
		ArrayList<Elephant> elephants = new ArrayList<Elephant>();
		int count = 0;
		int start = 0;
		while(in.hasNextLine()) {
			count++;
			String[] nums = in.nextLine().split(" ");
			elephants.add(new Elephant(count,Integer.parseInt(nums[0]),Integer.parseInt(nums[1])));
		}
		
		Collections.sort(elephants);
		
		/* testing sort
		for(int i = 0; i < elephants.size(); i++) {
			System.out.printf("%d %d %d\n", elephants.get(i).num,elephants.get(i).weight,elephants.get(i).iq);
		} */
		
		int[] cur = new int[elephants.size() + 1];
		int[] nxt = new int[elephants.size() + 1];
		int length = 0;
		
		for(int i = 1; i < elephants.size(); i++) {
			cur[i] = 1;
			nxt[i] = -1;
			for(int j = 0; j < i; j++) {
				if(cur[j] + 1 > cur[i] && elephants.get(i).iq < elephants.get(j).iq && elephants.get(i).weight > elephants.get(j).weight) {
					cur[i] = cur[j] + 1;
					nxt[i] = j;
				}
			}
			
			if(cur[i] > length) {
				length = cur[i];
				start = i;
			}
			
		}
		int[] outputQueue = new int[length];
		int ct = 0;
		for(int i = start; i >= 0; i = nxt[i]) {
			outputQueue[ct] = elephants.get(i).num;
			ct++;
		}
		
		System.out.printf("%d\n",length);
		for(int i = length - 1; i >= 0; i--) {
			System.out.printf("%d\n", outputQueue[i]);
		}
	}

}

class Elephant implements Comparable {
	int num,weight,iq;
	
	Elephant(int n, int w, int i) {
		num = n;
		weight = w;
		iq = i;
	}

	@Override
	public int compareTo(Object arg0) {
		Elephant e = (Elephant) arg0;
		
		if(weight == e.weight) {
			if(iq < e.iq)
				return 1;
			else if (iq == e.iq)
				return 0;
			else
				return -1;
		}
		
		else if (weight > e.weight) {
			return 1;
		}
		else {
			return -1;
		}
			
	}
}
