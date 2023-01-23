package main;
import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;
// a class made separately that consists of the entire menu. I don't really like doing it in the main class.

public class Menu {
	static Scanner scan = new Scanner(System.in);
	static Vector<User> dataList = new Vector<>();
	static Vector<MaleUser> maleList = new Vector<>();
	static Vector<FemaleUser> femaleList = new Vector<>();
	
	static Connect con = Connect.getConnection();
	static PreparedStatement ps;	
	
	static String selectQueryUser = "select * from msuser";
	static String selectQueryFemale = "select * from msfemaleuser";
	static String selectQueryMale = "select * from msmaleuser";
	static String insertQueryUser = "insert into msuser values (?, ?, ?, ?, ?, ?, ?)";
	static String insertQueryFemale = "insert into msfemaleuser values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	static String insertQueryMale = "insert into msmaleuser values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	static String deleteQuery = "delete from msuser where UserName = ?";
	static String deleteQueryFemale = "delete from msfemaleuser where UserName = ?";
	static String deleteQueryMale = "delete from msmaleuser where UserName = ?";
	
	String userName, userJob, userHobby, userMusicGenre, userMajor, userCampus;
	static String choosenName;
	int userAge;
	
	//the first thing the user sees when loading up the program, that calls to MainMenu()
	static void Greet() {
		System.out.println("\r\n"
				+ " .----------------.  .----------------.  .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.  .----------------. \r\n"
				+ "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\r\n"
				+ "| |   ______     | || |  _________   | || |  _________   | || |     _____    | || | ____  _____  | || |   _____      | || |     ____     | || | ____   ____  | || |  _________   | |\r\n"
				+ "| |  |_   _ \\    | || | |_   ___  |  | || | |_   ___  |  | || |    |_   _|   | || ||_   \\|_   _| | || |  |_   _|     | || |   .'    `.   | || ||_  _| |_  _| | || | |_   ___  |  | |\r\n"
				+ "| |    | |_) |   | || |   | |_  \\_|  | || |   | |_  \\_|  | || |      | |     | || |  |   \\ | |   | || |    | |       | || |  /  .--.  \\  | || |  \\ \\   / /   | || |   | |_  \\_|  | |\r\n"
				+ "| |    |  __'.   | || |   |  _|  _   | || |   |  _|  _   | || |      | |     | || |  | |\\ \\| |   | || |    | |   _   | || |  | |    | |  | || |   \\ \\ / /    | || |   |  _|  _   | |\r\n"
				+ "| |   _| |__) |  | || |  _| |___/ |  | || |  _| |___/ |  | || |     _| |_    | || | _| |_\\   |_  | || |   _| |__/ |  | || |  \\  `--'  /  | || |    \\ ' /     | || |  _| |___/ |  | |\r\n"
				+ "| |  |_______/   | || | |_________|  | || | |_________|  | || |    |_____|   | || ||_____|\\____| | || |  |________|  | || |   `.____.'   | || |     \\_/      | || | |_________|  | |\r\n"
				+ "| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\r\n"
				+ "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\r\n"
				+ " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \r\n"
				+ "\n");
		
		System.out.println("_░▒███████\r\n"
				+ "░██▓▒░░▒▓██\r\n"
				+ "██▓▒░__░▒▓██___██████\r\n"
				+ "██▓▒░____░▓███▓__░▒▓██     __      __       .__                               \r\n"
				+ "██▓▒░___░▓██▓_____░▒▓██   /  \\    /  \\ ____ |  |   ____  ____   _____   ____  \r\n"
				+ "██▓▒░_______________░▒▓██ \\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\ \r\n"
				+ "_██▓▒░______________░▒▓██  \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/ \r\n"
				+ "__██▓▒░____________░▒▓██    \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >\r\n"
				+ "___██▓▒░__________░▒▓██          \\/       \\/          \\/            \\/     \\/ \r\n"
				+ "____██▓▒░________░▒▓██      =================================================\r\n"
				+ "_____██▓▒░_____░▒▓██            TO ADELINE'S AND LUTHFI'S PROTOTYPE DATING APP!!!\r\n"
				+ "______██▓▒░__░▒▓██\r\n"
				+ "_______█▓▒░░▒▓██\r\n"
				+ "_________░▒▓██\r\n"
				+ "_______░▒▓██\r\n"
				+ "_____░▒▓██");
		
		Util.PressEnter();
		Util.CLS();
		MainMenu();
		
	}
	
	//Asks the user for inputs, which then adds into a class as well as a subclass depending on how they describe
	//themselves. The different classes will then be added into a Vector that separates them into Males or Females.
	static void InputData() {
		Util.CLS();
		System.out.println("  _                   _         _       _        \r\n"
				+ " (_)                 | |       | |     | |       \r\n"
				+ "  _ _ __  _ __  _   _| |_    __| | __ _| |_ __ _ \r\n"
				+ " | | '_ \\| '_ \\| | | | __|  / _` |/ _` | __/ _` |\r\n"
				+ " | | | | | |_) | |_| | |_  | (_| | (_| | || (_| |\r\n"
				+ " |_|_| |_| .__/ \\__,_|\\__|  \\__,_|\\__,_|\\__\\__,_|\r\n"
				+ "         | |                                     \r\n"
				+ "         |_| ");
		
		System.out.println("\nWhat is your name?");
		String name = scan.nextLine();
		System.out.println("How old are you? (19-26)");
		Integer age = scan.nextInt(); scan.nextLine();
		System.out.println("What is your current occupation?");
		String occ = scan.nextLine();
		System.out.println("What's your favourite hobby?");
		String hobby = scan.nextLine();
		System.out.println("What's your favourite music genre? (Please input something simple as this program has quite the limitations ^^)");
		String music = scan.nextLine();
		System.out.println("What are you currently majoring in?");
		String major = scan.nextLine();
		System.out.println("Which campus do you go to?");
		String campus = scan.nextLine();
		System.out.println("What is your gender?(M/F)");
		
//		DUMMY DATA
//		User user2 = new User("Adeline", 20, "Programmer", "Singing", "RnB", "CS", "BINUS");
//		User user3 = new User("Lily", 20, "Singer", "Singing", "Pop", "Management", "BINUS");
//		User user4 = new User("Luthfi", 20, "Programmer", "Playing games", "Jazz", "CS", "BINUS");
//		User user5 = new User("Reyn", 21, "Programmer", "Singing", "RnB", "Cyber", "BINUS");
//		dataList.add(user2);
//		dataList.add(user3);
//		dataList.add(user4);
//		dataList.add(user5);

		User user1 = new User(name, age, occ, hobby, music, major, campus);

		
		ps = con.prepareStatement(insertQueryUser);
		
		try {
			
			ps.setString(1, name);
			ps.setInt(2,  age);
			ps.setString(3, occ);
			ps.setString(4, hobby);
			ps.setString(5, music);
			ps.setString(6, major);
			ps.setString(7, campus);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String gen = scan.nextLine();
		if(gen.compareTo("M") == 0) {
			System.out.println("What gender are you interested in? (M/F)");
			String gendint = scan.nextLine();
			System.out.println("What age are you looking for? (We will approximate a range for you.)");
			int ageint = scan.nextInt();scan.nextLine();
			System.out.println("What occupation are you looking for in your match?");
			String occint = scan.nextLine();
			System.out.println("What particular hobby are you looking for in your match?");
			String hobbyint = scan.nextLine();
			System.out.println("What music genre would you like to listen to together with your match?");
			String musicint = scan.nextLine();
////			DUMMY DATA
//			MaleUser male2 = new MaleUser("Luthfi", 20, "Programmer", "Playing games", "Jazz", "CS", "BINUS", "F", 20, "SInger", "Singing", "Pop");
//			MaleUser male3 = new MaleUser("Reyn", 21, "Programmer", "Singing", "RnB", "Cyber", "BINUS", "F", 20, "Programmer", "Singing", "RnB");
//			maleList.add(male2);
//			maleList.add(male3);
//
			MaleUser male1 = new MaleUser(name, age, occ, hobby, music, major, campus, gendint, ageint, occint, hobbyint, musicint);
			maleList.add(male1);
		
			
			ps = con.prepareStatement(insertQueryMale);
			
			try {
				
				ps.setString(1, name);
				ps.setInt(2,  age);
				ps.setString(3, occ);
				ps.setString(4, hobby);
				ps.setString(5, music);
				ps.setString(6, major);
				ps.setString(7, campus);
				ps.setString(8, gendint);
				ps.setInt(9, ageint);
				ps.setString(10, occint);
				ps.setString(11, hobbyint);
				ps.setString(12, musicint);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("What gender are you interested in? (M/F)");
			String gendint = scan.nextLine();
			System.out.println("What age are you looking for? (We will approximate a range for you.)");
			int ageint = scan.nextInt();scan.nextLine();
			System.out.println("What occupation are you looking for in your match?");
			String occint = scan.nextLine();
			System.out.println("What particular hobby are you looking for in your match?");
			String hobbyint = scan.nextLine();
			System.out.println("What music genre would you like to listen to together with your match?");
			String musicint = scan.nextLine();
////			DUMMY DATA
//			FemaleUser female2 = new FemaleUser("Adeline", 20, "Programmer", "Singing", "RnB", "CS", "BINUS", "M", 21, "Programmer", "Singing", "RnB");
//			FemaleUser female3 = new FemaleUser("Lily", 20, "Singer", "Singing", "Pop", "Management", "BINUS", "M", 20, "Programmer", "Playing games", "Jazz");
//			femaleList.add(female2);
//			femaleList.add(female3);
//
			FemaleUser female1 = new FemaleUser(name, age, occ, hobby, music, major, campus, gendint, ageint, occint, hobbyint, musicint);
			femaleList.add(female1);
			
			
			ps = con.prepareStatement(insertQueryFemale);
			
			try {
				
				ps.setString(1, name);
				ps.setInt(2,  age);
				ps.setString(3, occ);
				ps.setString(4, hobby);
				ps.setString(5, music);
				ps.setString(6, major);
				ps.setString(7, campus);
				ps.setString(8, gendint);
				ps.setInt(9, ageint);
				ps.setString(10, occint);
				ps.setString(11, hobbyint);
				ps.setString(12, musicint);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dataList.add(user1);
		
		Util.PressEnter();
		MainMenu();
	}
	
	
	//Uses a for loop to print out all the data in the vector. Has a conditional to output another message
	//if the data list is empty. Uses a switch case to determine if the user wants to see all/male/female 
	//users of this app.
	static void ViewCandid() {
		Util.CLS();
		System.out.println(" __      ___               _                _____                _ _     _       _            \r\n"
				+ " \\ \\    / (_)             (_)              / ____|              | (_)   | |     | |           \r\n"
				+ "  \\ \\  / / _  _____      ___ _ __   __ _  | |     __ _ _ __   __| |_  __| | __ _| |_ ___  ___ \r\n"
				+ "   \\ \\/ / | |/ _ \\ \\ /\\ / / | '_ \\ / _` | | |    / _` | '_ \\ / _` | |/ _` |/ _` | __/ _ \\/ __|\r\n"
				+ "    \\  /  | |  __/\\ V  V /| | | | | (_| | | |___| (_| | | | | (_| | | (_| | (_| | ||  __/\\__ \\\r\n"
				+ "     \\/   |_|\\___| \\_/\\_/ |_|_| |_|\\__, |  \\_____\\__,_|_| |_|\\__,_|_|\\__,_|\\__,_|\\__\\___||___/\r\n"
				+ "                                    __/ |                                                     \r\n"
				+ "                                   |___/  \n\n");
		if(dataList.isEmpty()) {
			System.out.println("Please input the data first using the first option in the main menu, before proceeding!");
		}else {
			System.out.println("Which Data List would you like to see?");
			System.out.println("1. ALL GENDERS");
			System.out.println("2. Males");
			System.out.println("3. Females");
			System.out.println("4. Return to Main Menu");
			int listOpt = scan.nextInt();scan.nextLine();
			switch(listOpt) {
				case 1:{
					Util.CLS();
					
					dataList.clear();
					ps = con.prepareStatement(selectQueryUser);

					ResultSet rs;
					
					try {
						rs = ps.executeQuery();
						while(rs.next()) {
						
							String currName = rs.getString(1);
							int currAge = rs.getInt(2);
							String currJob = rs.getString(3);
							String currHobby = rs.getString(4);
							String currMusicGenre = rs.getString(5);
							String currMajor = rs.getString(6);
							String currCampus = rs.getString(7);
							
							User user1 = new User(currName, currAge, currJob, currHobby, currMusicGenre, currMajor, currCampus);
							dataList.add(user1);
							
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
					
					for (int i = 0; i < dataList.size(); i++) {
						  User user = dataList.get(i);
						  System.out.println("Data No. "+(i+1));
						  System.out.println("=========================================");
						  System.out.println("Name: " + user.getName());
						  System.out.println("Age: " + user.getAge());
						  System.out.println("Major: " + user.getMajor());
						  System.out.println("Campus: " + user.getCampus());
						  System.out.println("Occupation: " + user.getOcc());
						  System.out.println("Hobby: " + user.getHobby());
						  System.out.println("Music: " + user.getMusic());
						  System.out.println("---");
						  System.out.println("=========================================\n");
						}
				
					Util.PressEnter();
					ViewCandid();
					break;
				}case 2:{
					Util.CLS();
					
					maleList.clear();
					ps = con.prepareStatement(selectQueryMale);

					ResultSet rs;
					
					try {
						rs = ps.executeQuery();
						while(rs.next()) {
						
							String currName = rs.getString(1);
							int currAge = rs.getInt(2);
							String currJob = rs.getString(3);
							String currHobby = rs.getString(4);
							String currMusicGenre = rs.getString(5);
							String currMajor = rs.getString(6);
							String currCampus = rs.getString(7);
							String currGenInt = rs.getString(8);
							int currAgeInt = rs.getInt(9);
							String currOccInt = rs.getString(10);
							String currHobbyInt = rs.getString(11);
							String currMusicInt = rs.getString(12);
							
							MaleUser male1 = new MaleUser(currName, currAge, currJob, currHobby, currMusicGenre, currMajor, 
									currCampus, currGenInt, currAgeInt, currOccInt, currHobbyInt, currMusicInt);
							maleList.add(male1);
							dataList.add(male1);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
					
					for (int i = 0; i < maleList.size(); i++) {
						  MaleUser muser = maleList.get(i);
						  System.out.println("Data No. "+(i+1));
						  System.out.println("=========================================");
						  System.out.println("Name: " + muser.getName());
						  System.out.println("Age: " + muser.getAge());
						  System.out.println("Major: " + muser.getMajor());
						  System.out.println("Campus: " + muser.getCampus());
						  System.out.println("Occupation: " + muser.getOcc());
						  System.out.println("Hobby: " + muser.getHobby());
						  System.out.println("Music: " + muser.getMusic());
						  System.out.println("---");
						  System.out.println("=========================================\n");
						}
					Util.PressEnter();
					ViewCandid();
					break;
				}case 3:{
					Util.CLS();
					
					femaleList.clear();
					ps = con.prepareStatement(selectQueryFemale);

					ResultSet rs;
					
					try {
						rs = ps.executeQuery();
						while(rs.next()) {
						
							String currName = rs.getString(1);
							int currAge = rs.getInt(2);
							String currJob = rs.getString(3);
							String currHobby = rs.getString(4);
							String currMusicGenre = rs.getString(5);
							String currMajor = rs.getString(6);
							String currCampus = rs.getString(7);
							String currGenInt = rs.getString(8);
							int currAgeInt = rs.getInt(9);
							String currOccInt = rs.getString(10);
							String currHobbyInt = rs.getString(11);
							String currMusicInt = rs.getString(12);
							
							FemaleUser female1 = new FemaleUser(currName, currAge, currJob, currHobby, currMusicGenre, currMajor, 
									currCampus, currGenInt, currAgeInt, currOccInt, currHobbyInt, currMusicInt);
							femaleList.add(female1);
							dataList.add(female1);
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
					for (int i = 0; i < femaleList.size(); i++) {
						  FemaleUser fuser = femaleList.get(i);
						  System.out.println("Data No. "+(i+1));
						  System.out.println("=========================================");
						  System.out.println("Name: " + fuser.getName());
						  System.out.println("Age: " + fuser.getAge());
						  System.out.println("Major: " + fuser.getMajor());
						  System.out.println("Campus: " + fuser.getCampus());
						  System.out.println("Occupation: " + fuser.getOcc());
						  System.out.println("Hobby: " + fuser.getHobby());
						  System.out.println("Music: " + fuser.getMusic());
						  System.out.println("---");
						  System.out.println("=========================================\n");
						}
					Util.PressEnter();
					ViewCandid();
					break;
				}case 4:{
					MainMenu();
					break;
				}
			}
		}
		Util.PressEnter();
		MainMenu();
	}
	
	
	//First it prints out all the data set and asks the user for which is theirs so that the program can
	//find who their best match is by calling another function called calculateCompatibilityScore. After
	//returning the value, there's a loop that compares the user's compatibility score with other users of the
	//vector and prints out the one with the highest compatibility score.
	static void Match() {
		System.out.println("  ______ _           _ _               __  __       _       _                     \r\n"
				+ " |  ____(_)         | (_)             |  \\/  |     | |     | |                    \r\n"
				+ " | |__   _ _ __   __| |_ _ __   __ _  | \\  / | __ _| |_ ___| |__   ___  ___       \r\n"
				+ " |  __| | | '_ \\ / _` | | '_ \\ / _` | | |\\/| |/ _` | __/ __| '_ \\ / _ \\/ __|      \r\n"
				+ " | |    | | | | | (_| | | | | | (_| | | |  | | (_| | || (__| | | |  __/\\__ \\_ _ _ \r\n"
				+ " |_|    |_|_| |_|\\__,_|_|_| |_|\\__, | |_|  |_|\\__,_|\\__\\___|_| |_|\\___||___(_|_|_)\r\n"
				+ "                                __/ |                                             \r\n"
				+ "                               |___/                             ");
	    //for loop to print out all the data, so the user can tell which is theirs and which they want to choose
		//as a subject to the algorithm.	
		for (int i = 0; i < dataList.size(); i++) {
			  User user = dataList.get(i);
			  System.out.println("Data No. "+(i+1));
			  System.out.println("=========================================");
			  System.out.println("Name: " + user.getName());
			  System.out.println("Age: " + user.getAge());
			  System.out.println("Major: " + user.getMajor());
			  System.out.println("Campus: " + user.getCampus());
			  System.out.println("Occupation: " + user.getOcc());
			  System.out.println("Hobby: " + user.getHobby());
			  System.out.println("Music: " + user.getMusic());
			  System.out.println("---");
			  System.out.println("=========================================\n");
			}
		
		int index;
		System.out.println("Please enter the number of your data's order.");
		index = scan.nextInt(); scan.nextLine();

		try {
			System.out.println("Please enter the number of your data's order.");
			index = scan.nextInt(); scan.nextLine();
			
		} catch (Exception e) {
			System.out.println("Try Again!! Input Invalid");
		}
		Vector<User> bestMatches = new Vector<>();
	    
	    double bestCompatibilityScore = 0;

	    //a for loop to compare the compatibility score of every user with the picked data.
	    for (User otherUser : dataList) {
	        double compatibilityScore = Util.calculateCompatibilityScore(dataList.get(index), otherUser);
	        
	        if (compatibilityScore > bestCompatibilityScore) {
	            bestCompatibilityScore = compatibilityScore;
	            bestMatches.clear();
	        }

	        if (compatibilityScore == bestCompatibilityScore) {
	            bestMatches.add(otherUser);
	        }
	    }

	    System.out.println("Congratulations! We found the perfect match for you!");
	    for (int i = 0; i < bestMatches.size(); i++) {
			  User user = bestMatches.get(i);
			  System.out.println("Match No. "+(i+1));
			  System.out.println("=========================================");
			  System.out.println("Name: " + user.getName());
			  System.out.println("Age: " + user.getAge());
			  System.out.println("Major: " + user.getMajor());
			  System.out.println("Campus: " + user.getCampus());
			  System.out.println("Occupation: " + user.getOcc());
			  System.out.println("Hobby: " + user.getHobby());
			  System.out.println("Music: " + user.getMusic());
			  System.out.println("=========================================\n");
			}
		Util.PressEnter();
		Util.CLS();
	}
	
	//quite similar viewing data, however the program asks for the user's name, which will then delete the class
	//from the Vector of all corresponding names.
	static void DelData() {
		System.out.println("  _____       _      _   _               _____        _          /\\       /\\ \r\n"
				+ " |  __ \\     | |    | | (_)             |  __ \\      | |        |/\\|     |/\\|\r\n"
				+ " | |  | | ___| | ___| |_ _ _ __   __ _  | |  | | __ _| |_ __ _      ______   \r\n"
				+ " | |  | |/ _ \\ |/ _ \\ __| | '_ \\ / _` | | |  | |/ _` | __/ _` |    |______|  \r\n"
				+ " | |__| |  __/ |  __/ |_| | | | | (_| | | |__| | (_| | || (_| |              \r\n"
				+ " |_____/ \\___|_|\\___|\\__|_|_| |_|\\__, | |_____/ \\__,_|\\__\\__,_|              \r\n"
				+ "                                  __/ |                                      \r\n"
				+ "                                 |___/                                       ");
		if(dataList.isEmpty()) {
			System.out.println("Please input the data first using the first option in the main menu, before proceeding!");
		}else {
		System.out.println("\n\n We're sad to see you go!");
		System.out.println("However, please input your name so we can wipe your data from the system");
		String input = scan.nextLine();
		
//		uses a loop to check matching names within all the vectors so that it can remove it accordingly.
			for (int i = 0; i < dataList.size(); i++) {	
				String currentName = dataList.get(i).getName();
		      		if (currentName.equals(input)) {
		      			dataList.remove(i);
		      			for(int j=0; j<maleList.size();j++) {
		      				if(currentName.equals(input)) {
		      					maleList.remove(j);
		      				}
		      			}
		      			
		      			for(int j=0; j<femaleList.size();j++) {
		      				if(currentName.equals(input)) {
		      					femaleList.remove(j);
		      				}
		      			}
		      		}	
		    	}
			
			ps = con.prepareStatement(deleteQuery);
			
			try {
				
				ps.setString(1, input);
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ps = con.prepareStatement(deleteQueryFemale);
			
			try {
				
				ps.setString(1, input);
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ps = con.prepareStatement(deleteQueryMale);
			
			try {
				
				ps.setString(1, input);
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("DATA SUCCESSFULLY DELETED");
			
			Util.PressEnter();
			MainMenu();
		}
	}
	
	//the main switch case that acts as the spine of the entire program. This prompts the user as to what they want
	//to do and calls out to other function to do their intended purpose.
	static void MainMenu() {
		System.out.println("========================================");
		System.out.println("              MAIN MENU!!!");
		System.out.println("========================================");
		System.out.println("1. Input Data.");
		System.out.println("2. View Candidates.");
		System.out.println("3. MATCH!");
		System.out.println("4. Delete Data.");
		System.out.println("5. Exit.");
		System.out.println("----------------------------------------");
		System.out.println("Input option:");
		int key = scan.nextInt();scan.nextLine();
		while(key<=0||key>=6) {
			System.out.println("Please Input a Correct Option.");
			key = scan.nextInt();scan.nextLine();
		}

		switch (key) {
			case 1: {
				Util.CLS();
				InputData();
				break;
			}
			case 2: {
				Util.CLS();
				ViewCandid();
				break;
			}
			case 3: {
				Util.CLS();
				Match();
				break;
			}
			case 4: {
				Util.CLS();
				DelData();
				break;
			}
			case 5: {
				Util.CLS();
				System.out.println("  ____                   _                \r\n"
						+ " |  _ \\                 | |               \r\n"
						+ " | |_) |_   _  ___      | |__  _   _  ___ \r\n"
						+ " |  _ <| | | |/ _ \\     | '_ \\| | | |/ _ \\\r\n"
						+ " | |_) | |_| |  __/     | |_) | |_| |  __/\r\n"
						+ " |____/ \\__, |\\___|     |_.__/ \\__, |\\___|\r\n"
						+ "         __/ |                  __/ |     \r\n"
						+ "        |___/                  |___/      ");
			}	
		}
	}
}
