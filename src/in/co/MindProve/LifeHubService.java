package in.co.MindProve;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

import in.co.Dto.LifeHubDto;
import in.co.JDBCDataSource.DataBaseConnection;

public class LifeHubService {

	public static void createLifeHubEvent() throws SQLException {
		Scanner sc = new Scanner(System.in);
		LifeHubDto dto = new LifeHubDto();
		System.out.println("Please Enter User Id");
		String userId = sc.next();
		dto.setUserId(userId);

		System.out.println("Please Enter Group Id");
		String groupId = sc.next();
		dto.setGroupId(groupId);

		System.out.println("Please Enter Event Type");
		System.out.println("Event Types are");
		System.out.println("1 : Accident");
		System.out.println("2 : Cancer");
		System.out.println("3 :Pregnancy");

		String eventType = sc.next();
		dto.setEventType(eventType);

		if (eventType.equalsIgnoreCase("Accident")) {

			eventType = "A";
		} else if (eventType.equalsIgnoreCase("Cancer")) {
			eventType = "C";

		} else if (eventType.equalsIgnoreCase("Pregnancy")) {
			eventType = "P";

		}
		System.out.println("Please Enter Active Indicator");
		String activeIndicator = sc.next();
		dto.setActiveIndicator(activeIndicator);

		System.out.println("Please Enter Event Start Date Please Enter Date In Format(MM/dd/YYYY)");
		String eventStartDateString = sc.next();
		dto.setEventStartDateString(eventStartDateString);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YYYY");
		java.util.Date eventStartDate = null;

		try {
			eventStartDate = simpleDateFormat.parse(eventStartDateString);

		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		System.out.println("Please Enter Event End Date Please Enter Date In Format(MM/dd/YYYY)");
		String eventEndDateString = sc.next();
		java.util.Date eventEndDate = null;
		try {

			eventEndDate = simpleDateFormat.parse(eventEndDateString);

		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		System.out.println("Please Enter Event Status Indicator");
		String eventStatusIndicator = sc.next();

		String CreatedBy = userId;
		java.util.Date CreatedDate = new java.util.Date();

		Connection connection = null;

		try {

			connection = DataBaseConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT   MAX(EVENT_ID) FROM GA_PORTAL");
			Long maxEventId = 1L;

			if (rs.next()) {
				maxEventId = rs.getLong(1);

			}
			Long eventId = ++maxEventId;
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into GA_PORTAL( USER_ID,GRP_ID,EVENT_TYPE,EVENT_ID,ACTIVE_IN,EVENT_START_DT,EVENT_END_DT,EVENT_STATUS_IN,CREATE_BY,CREATE_TS) values (?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, groupId);
			preparedStatement.setString(3, eventType);
			preparedStatement.setLong(4, eventId);
			preparedStatement.setString(5, activeIndicator);
			preparedStatement.setDate(6, new java.sql.Date(eventStartDate.getTime()));
			preparedStatement.setDate(7, new java.sql.Date(eventEndDate.getTime()));
			preparedStatement.setString(8, eventStatusIndicator);
			preparedStatement.setString(9, CreatedBy);
			preparedStatement.setTimestamp(10, new Timestamp(CreatedDate.getTime()));

			int row = preparedStatement.executeUpdate();
			if (row > 0) {

				System.out.println("Event Created Sucessfully");

			} else {
				System.out.println("Event Not Created");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			connection.close();
		}
	}

	public static void updateLifeHubEvent() throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Event Id");
		long eventId = sc.nextLong();

		System.out.println("Please Enter User Id");
		String userId = sc.next();
		System.out.println("Please Enter Group Id");
		String groupId = sc.next();
		System.out.println("Please Enter Event Type");
		System.out.println("Event Types are");
		System.out.println("Pregnancy");
		System.out.println("Accident");
		System.out.println("Cancer");

		String eventType = sc.next();

		if (eventType.equalsIgnoreCase("Pregnancy")) {
			eventType = "P";

		} else if (eventType.equalsIgnoreCase("Accident")) {
			eventType = "A";

		} else if (eventType.equalsIgnoreCase("Cancer")) {
			eventType = "C";

		}
		System.out.println("Please Enter Active Indicator");
		String activeIndicator = sc.next();

		System.out.println("Please Enter Event Start Date Please Enter Date In Format(MM/dd/YYYY)");
		String eventStartDateString = sc.next();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YYYY");
		java.util.Date eventStartDate = null;

		try {

			eventStartDate = simpleDateFormat.parse(eventStartDateString);

		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Please Enter Event End Date Please Enter Date In Format(MM/dd/yyy) ");
		String eventEndDateString = sc.next();

		java.util.Date eventEndDate = null;
		try {

			eventEndDate = simpleDateFormat.parse(eventEndDateString);

		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		System.out.println("Please Enter  Event Status Indicator");

		String eventStatusIndicator = sc.next();
		String createdBy = userId;
		java.util.Date createdDate = new java.util.Date();

		Connection connection = null;
		try {
			connection = DataBaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE GA_PORTAL SET USER_ID = ?,GRP_ID=?,EVENT_TYPE=?,ACTIVE_IN = ?,EVENT_START_DT = ?,EVENT_END_DT=?,EVENT_STATUS_IN= ?,CREATE_BY=? where EVENT_ID = ?");
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, groupId);
			preparedStatement.setString(3, eventType);
			preparedStatement.setString(4, activeIndicator);
			preparedStatement.setDate(5, new java.sql.Date(eventStartDate.getTime()));
			preparedStatement.setDate(6, new java.sql.Date(eventEndDate.getTime()));
			preparedStatement.setString(7, eventStatusIndicator);
			preparedStatement.setString(8, createdBy);
			preparedStatement.setLong(9, eventId);
			int row = preparedStatement.executeUpdate();

			if (row > 0) {
				System.out.println("Update Sucessfully");

			} else {
				System.out.println("NO record found with tha given id");

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			connection.close();
		}

	}

	public static void deleteLifeHubEvent() throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Event Id");
		Long eventId = sc.nextLong();
		Connection connection = null;

		try {
			connection = DataBaseConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from GA_PORTAL where EVENT_ID = ?");
			preparedStatement.setLong(1, eventId);
			int row = preparedStatement.executeUpdate();

			if (row > 0) {
				System.out.println("Event Delete Successfully");

			} else {
				System.out.println("Event Delete UnSuccessfully");

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			connection.close();
		}
	}

	public static void viewLifeHubEvent() throws SQLException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Event Id");
		long eventId = sc.nextLong();
		Connection connection = null;

		try {
			connection = DataBaseConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from GA_PORTAL where EVENT_ID = ?");
			preparedStatement.setLong(1, eventId);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				System.out.println("User Id :" + rs.getString(1));
				System.out.println("Group Id:" + rs.getString(2));
				System.out.println("Event Type :" + rs.getString(3));
				System.out.println("Event Id :" + rs.getString(4));
				System.out.println("Active Indicator:" + rs.getString(5));
				System.out.println("Event Start Date:" + rs.getString(6));
				System.out.println("Event End Date:" + rs.getString(7));
				System.out.println("Event Status Indicator :" + rs.getString(8));

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			connection.close();
		}

	}

}