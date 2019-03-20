import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int cases = 0;
		if (in.hasNextLine())
			cases = Integer.parseInt(in.nextLine());

		for (int c = 0; c < cases; c++) {

			int guests = 0, chops = 0;
			if (in.hasNextLine()) {
				String[] t = in.nextLine().split(" ");
				guests = Integer.parseInt(t[0]) + 8;
				chops = Integer.parseInt(t[1]);
			}

			int[] len = new int[chops + 1];

			if (in.hasNextLine()) {
				String[] t = in.nextLine().split(" ");
				for (int i = 1; i < chops + 1; i++)
					len[i] = Integer.parseInt(t[i-1]);
			}

			int[] badness = new int[chops + 1];
			for (int i = 1; i < chops + 1; i++) {
				badness[i] = (len[i] - len[i - 1]) * (len[i] - len[i - 1]);
			}

			int[] minBad = new int[chops + 1];

			for (int i = 1; i < guests + 1; i++) {
				int j;
				for (j = chops - 3 * (guests - i) - 1; j >= 2 * i; j--)
					minBad[j] = badness[j] + minBad[j - 2];

				for (j = j + 2; j < chops - 3 * (guests - i); j++) {
					if(minBad[j] <= minBad[j-1])
						minBad[j] = minBad[j];
					else
						minBad[j] = minBad[j-1];
				}

				minBad[chops - 3 * (guests - i)] = minBad[chops - 3 * (guests - i) - 1];

			}
			/*for(int i = 0; i < minBad.length; i++) {
				System.out.print(minBad[i] + " ");
			}
			System.out.println();*/
			System.out.print(minBad[chops] + "\n");
		}
	}

}//
