package main;

import java.util.Scanner;

public class User {

	public Profile userProfile;
	String userEmail;

	private String userPassword;
	private String username;
	
	//Creating a new User
	public User() {
		System.out.println("Please enter your email address");
		Scanner input = new Scanner(System.in);

		//if email is a valid email
		this.userEmail = input.next();
		System.out.println("Email accepted!\n");

		boolean password_complete = false;
		while(!password_complete) {
			System.out.println("Please enter your new password");
			String pass = input.nextLine();

			System.out.println("Please confirm your new password");
			String confirm = input.nextLine();

			if(pass.equals(confirm)) {
				this.userPassword = pass;
				password_complete = true;
				System.out.println("Your password has been set!\n");
			}
			else {
				System.out.println("Your passwords did not match, please try again\n");
			}
		}

		boolean user_name_selected = false;
		while(!user_name_selected){
			System.out.println("Please enter your desired username");
			String user_name = input.nextLine();
		/*
		 * if username is not taken ->
		 * complete creation
		 * else ->
		 * username is taken error
		 */
			System.out.println("You entered " + user_name + " as your user name. Are you sure you want this to be your username? (y/n)");
			String response = input.next();

			if(response.equals("y")) {
				this.username = user_name;
				System.out.println("Username set successfully!\n");
				user_name_selected = true;
			}
		}
		System.out.println("Would you like to create your profile now? (y/n)");
		String response = input.next();
		if(response.equals("y")) {
			System.out.println("Okay, let's get started!\n");
			this.userProfile = this.createProfile();
		}
		else {
			System.out.println("Okay, don't worry, you can always create your profile later.\n");
		}

		input.close();
	}
	
	//Re-Creating an existing user
	public User(String username, String userPassword) {
		/*
		 * if user is valid ->
		 * retrieve user data from database
		 * else ->
		 * send incorrect login error
		 */	
	}

	public Profile createProfile() {
		Profile p = new Profile();

		System.out.println("Would you like to enter your name? (y/n)");
		Scanner input = new Scanner(System.in);

		String response = input.next();

		if(getConfirmation(input.next())) {
			p.setName();
		}

		System.out.println("Would you like to select your profile picture from pictures uploaded to the project? (y/n)");

		if(getConfirmation(input.next())) {
			p.setProfilePicture();
		}

		System.out.println("Would you like to set your spirit animal now? (y/n)");

		if(getConfirmation(input.next())) {
			System.out.println("What is your spirit animal?");
			p.setSpiritAnimal(input.next());
		}

		// TODO: Set the rest of the Profile fields here:

		
		this.userProfile = p;
		System.out.println("Congratulations! Your profile has been created successfully!");
		return p;
	}

	/**
	 * Sets each element of the user's profile to null, then sets the userProfile to null
	 */
	void deleteProfile() {
		this.userProfile.removeName();
		this.userProfile.removeProfilePicture();
		this.userProfile = null;
		System.out.println("Profile successfully deleted");
	}

	private boolean getConfirmation(String userInput) {
		userInput = userInput.toLowerCase().trim();

		if(userInput.equals("y")) {
			return true;
		}

		if(!userInput.equals("n")) {
			System.out.println("You did not enter a valid string. Assuming no.");
		}

		return false;
	}

}
