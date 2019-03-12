package main;

import main.utility.AppUtilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Profile {

	private String myName;
	private BufferedImage profilePicture;
	private String genderIdentity;
	private String aboutMe;

	public static void main(String[] args){
		Profile p = setupProfile();

		System.out.println("All done, "+p.getName()+"!");
		System.out.println(p.aboutMe);
		System.out.println(p.genderIdentity);
	}
	public static Profile setupProfile(){
		Profile p = new Profile();


		p.setAboutMe(AppUtilities.collectInput("Tell us about yourself:"));
		p.setGenderIdentity(AppUtilities.collectInput("How do you identify your gender?"));

		/*
		If you guys like this, you can convert your use cases to follow this structure
		for setting fields
			-Just a suggestion
		 */


		return p;
	}


	public void setAboutMe(String aboutMe){
		this.aboutMe = aboutMe;
	}

	public String getAboutMe(){
		return aboutMe;
	}

	public void setGenderIdentity(String genderIdentity){
		this.genderIdentity = genderIdentity;
	}

	public String getGenderIdentity(){
		return genderIdentity;
	}


	public void setName() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your first name below");
		String response = input.next();
		System.out.println("And now please enter your last name below");
		String response2 = input.next();
		this.myName = response + " " + response2;
		System.out.println("Great! Your name will appear as: " + this.myName + "!\n");
	}

	public String getName(){
		return myName;
	}

	public void setProfilePicture() {
		System.out.println("Is the picture saved in the file structure? (y/n)");
		Scanner input = new Scanner(System.in);
		String response = input.next();
		boolean upload_complete = false;
		while(!upload_complete){
			if(response.equals("y")){
				System.out.println("Good! Now please enter the name of your picture file. (include .jpg, .png, etc.)");
				response = input.next();
				try{
					///////
					
					BufferedImage picture = ImageIO.read(new File(response));
					this.profilePicture = picture;
					/*
					 * This section will need to be changed once the server is set up to something more like:
					 * try {
					 * 		URL url = new URL(getCodeBase(), "pictures/sobble_is_best.png");
					 * 		img = ImageIO.read(url);
					 * }catch(IOException e){
					 * 		System.out.println("The picture you specified seems to be unavailable, please try again");
					 * }
					 */
					///////
					System.out.println("Your profile picture was added successfuly! The following picture will be displayed.");
					JFrame frame = new JFrame();
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.getContentPane().setLayout(new GridLayout(1, 1));
					ImagePanel panel = new ImagePanel(this.profilePicture);
			        frame.getContentPane().add(panel);
			        frame.pack();
			        frame.setVisible(true);
				}catch(IOException e){
					System.out.println("The file name you specified was invalid, please try again");
				}
			}
		}
	}

	public void removeName() {
		this.myName = null;
	}

	public void removeProfilePicture() {
		this.profilePicture = null;
	}
	
	static class ImagePanel extends JPanel
    {
        private final BufferedImage image;

        ImagePanel(BufferedImage image)
        {
            this.image = image;
        }

        @Override
        public Dimension getPreferredSize()
        {
            if (super.isPreferredSizeSet())
            {
                return super.getPreferredSize();
            }
            return new Dimension(image.getWidth(), image.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
    }
	
	
	
	
	
	
	
}
