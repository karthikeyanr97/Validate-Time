import java.util.Scanner;

public class ValidateTime extends UserMainCode {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the time:");
		String time = scanner.nextLine();

		int result = validateTime(time);

		if (result == 1)
			System.out.println("Valid time");
		else
			System.out.println("Invalid time");

		scanner.close();
	}
}

class UserMainCode {
	public static int validateTime(String time) {

		String shortTime = "";

		for (int i = 0; i < time.length(); i++) {
			if (time.charAt(i) >= '0' && time.charAt(i) <= '9' && (i < 2 || (i > 2 && i < 5))) {
				shortTime += time.charAt(i);

			} else {

				if ((time.charAt(i) == ':' && (Byte.parseByte(shortTime)) <= 12)
						|| (time.charAt(i) == ' ' && (Byte.parseByte(shortTime)) <= 59))
					shortTime = "";
				else if (time.charAt(i) == 'a' || time.charAt(i) == 'p' || time.charAt(i) == 'm')
					shortTime += time.charAt(i);
				else
					return -1;
			}
		}

		if (shortTime.equalsIgnoreCase("am") || shortTime.equalsIgnoreCase("pm"))
			return 1;
		else
			return -1;

	}
}
