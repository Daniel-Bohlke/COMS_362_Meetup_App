package app;


import app.Controllers.AccountController;
import app.Controllers.ProfileController;
import app.models.Account;
import app.models.Profile;

import java.util.HashMap;
import java.util.Map;

public class App
{
	//TODO create account here or in Account.java
	public static Map<String,Object> sessionVariables = new HashMap<>();

	public static void main(String[] args)
	{
		Account myAccount = null;

		System.out.println("Welcome!");


		if(InputReader.inputYesNo("Would you like to create an account?")) {
			while(true) {
				System.out.println();
				String username = InputReader.collectInput("Please enter a username for the account.");


				String password = InputReader.collectInput("Please enter a password for the account.");

				String comparisonPassword = InputReader.collectInput("Enter your password again to confirm.");
				try {
					myAccount = AccountController.createAccount(username, password, comparisonPassword);
					break;
				}
				catch(IllegalArgumentException e) {
					System.out.println("Password creation failed! " + e);
					System.out.println("Restarting Account creation");
				}
			}
		}
		else {
			System.out.println("No? Okay then. Have a good day!");
			InputReader.closeInputReader();
			System.exit(0);
		}


		if(InputReader.inputYesNo("Would you like to create your profile?"))
		{
			Profile myProfile = ProfileController.createProfile();
			myAccount.setProfile(myProfile);
			try {
				ProfileController.insertProfile(myProfile);
				System.out.println("Save Successful");
			}catch (Exception e){
				e.printStackTrace();
				System.out.println("Save Unsuccessful");
			}
		}
		else
		{
			System.out.println("No? That's okay! You can always create it later.");
		}

		runApp();
	}

	private static void runApp(){
		while(!InputReader.inputYesNo("Would you like to quit?"));
	}

}
