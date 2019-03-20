import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int day = 0;
		while (in.hasNextLine()) {
			day++;
			int appts = Integer.parseInt(in.nextLine());
			if(appts == 0) {
				System.out.printf(
						"Day #%d: the longest nap starts at 10:00 and will last for 8 hours and 0 minutes.\n",
						day);
				continue;
			}
			Event[] events = new Event[appts];
			for (int a = 0; in.hasNextLine() && a < appts; a++) {
				String line = in.nextLine();
				Scanner scan = new Scanner(line);
				events[a] = new Event(scan.next(), scan.next());
				scan.close();
			}

			// process times
			Event[] sorted = sortEvents(events);

			// output longest break
			int longestTime = sorted[0].getStartTime() - (10 * 60);
			int longestIndex = -1;

			for (int i = 0; i < appts; i++) {
				int time;
				if (i != appts - 1) {
					time = sorted[i + 1].getStartTime() - sorted[i].getEndTime();
				} else {
					time = (18 * 60) - sorted[i].getEndTime();
				}

				if (time > longestTime) {
					longestTime = time;
					longestIndex = i;
				}
			}

			if (longestTime < 60) {
				if (longestIndex == -1)
					System.out.printf("Day #%d: the longest nap starts at 10:00 and will last for %d minutes.\n", day,
							longestTime);
				else
					System.out.printf("Day #%d: the longest nap starts at %s and will last for %d minutes.\n", day,
							sorted[longestIndex].endString, longestTime);
			} else {
				int hours = longestTime / 60;
				int min = longestTime % 60;

				if (longestIndex == -1)
					System.out.printf(
							"Day #%d: the longest nap starts at 10:00 and will last for %d hours and %d minutes.\n",
							day, hours, min);
				else
					System.out.printf(
							"Day #%d: the longest nap starts at %s and will last for %d hours and %d minutes.\n", day,
							sorted[longestIndex].endString, hours, min);
			}

			/*// debug
			for (int i = 0; i < appts; i++) {
				sorted[i].print();
			}*/
		}
	}

	public static Event[] sortEvents(Event[] events) {
		Event[] sorted = new Event[events.length];
		for (int j = 0; j < events.length; j++) {
			int minTime = 99999999;
			int mindex = -1;
			for (int i = 0; i < events.length; i++) {
				if (!(events[i].getSorted()) && events[i].getStartTime() < minTime) {
					minTime = events[i].getStartTime();
					mindex = i;
				}
			}
			sorted[j] = events[mindex];
			events[mindex].setSorted();
		}

		return sorted;
	}
}

class Event {
	int startTime;
	int endTime;
	String startString;
	String endString;
	boolean sorted;

	Event(String start, String end) {
		startString = start;
		endString = end;
		startTime = toMin(start);
		endTime = toMin(end);
		sorted = false;
	}

	int toMin(String time) {
		String[] tokens = time.split(":");
		int minutes = 0;

		minutes += Integer.parseInt(tokens[0]) * 60;
		minutes += Integer.parseInt(tokens[1]);

		return minutes;
	}

	int getStartTime() {
		return startTime;
	}

	int getEndTime() {
		return endTime;
	}

	String getStartString() {
		return startString;
	}

	String getEndString() {
		return endString;
	}

	void setStartTime(int time) {
		startTime = time;
	}

	void setEndTime(int time) {
		endTime = time;
	}

	void setStartString(String time) {
		startString = time;
		setStartTime(toMin(time));
	}

	void setEndString(String time) {
		endString = time;
		setEndTime(toMin(time));
	}

	boolean getSorted() {
		return sorted;
	}

	void setSorted() {
		sorted = true;
	}

	void print() {
		System.out.print(startString + " " + endString + "\n");
	}

}
