package main;
import java.util.Scanner;
import model.*;

public class Util {
	static Scanner scan = new Scanner(System.in);
	
	//basic pressEnter function
	static void PressEnter() {
		System.out.println("\n\nPress Enter to Continue");
		scan.nextLine();
	}
	
	//function to clear skin for cleaner look
	static void CLS() {
		for(int i=0; i<50; i++) {
			System.out.println("\n");
		}
	}
	
	//the algorithm that increases a user compatibility score with another, according to if they
	//have similar attributes, or if their attributes matches well with what another person is
	//looking for in a partner.
	public static double calculateCompatibilityScore(User user, User otherUser) {
	    double compatibilityScore = 0;

	    if (user.getName().equals(otherUser.getName())) {
	        compatibilityScore++;
	    }
	    if (user.getAge() == otherUser.getAge()) {
	        compatibilityScore++;
	    }
	    if (user.getOcc().equals(otherUser.getOcc())) {
	        compatibilityScore++;
	    }
	    if (user.getHobby().equals(otherUser.getHobby())) {
	        compatibilityScore++;
	    }
	    if (user.getMusic().equals(otherUser.getMusic())) {
	        compatibilityScore++;
	    }
	    if (user.getCampus().equals(otherUser.getCampus())) {
	        compatibilityScore++;
	    }
	    if (user.getMajor().equals(otherUser.getMajor())) {
	        compatibilityScore++;
	    }
	    
	    if (user instanceof MaleUser && otherUser.getGendint().equals("female")) {
	        compatibilityScore++;
	    } else if (user instanceof FemaleUser && otherUser.getGendint().equals("male")) {
	        compatibilityScore++;
	    }
	    
	    if (user.getLookingForMusic().contains(otherUser.getMusic())) {
	        compatibilityScore++;
	    }
	    if (otherUser.getLookingForHobby().contains(user.getHobby())) {
	        compatibilityScore++;
	    }
	    if (otherUser.getLookingForOcc().contains(user.getOcc())) {
	        compatibilityScore++;
	    }

	    return compatibilityScore;
	}
	
}
