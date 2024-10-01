package in.co.MindProve;

import java.sql.SQLException;
import java.util.Scanner;

public class LifeHubMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		boolean flag = true;
		while (flag) {
			System.out.println("Welcome to GA_Portal");
			System.out.println("Please Select Any Option");
			System.out.println("Operations : Write Number to perform Operations");
			System.out.println("1 : Create Event");
			System.out.println("2 : Update Event");
			System.out.println("3 : Delete Event");
			System.out.println("4 : View Event");
			System.out.println("5 :  Quit");

			Scanner sc = new Scanner(System.in);
			int operationNumber = sc.nextInt();

			if (operationNumber == 5) {
				break;

			}

			if (operationNumber == 1) {
				LifeHubService.createLifeHubEvent();

			}
			if (operationNumber == 2) {
				LifeHubService.updateLifeHubEvent();

			}
			if (operationNumber == 3) {
				LifeHubService.deleteLifeHubEvent();
			}
			if (operationNumber == 4) {
				LifeHubService.viewLifeHubEvent();

			}

		}

	}

}
