package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Profile {

	BufferedImage profilePicture;
	
	String myName;
	private String spiritAnimal;
	
	public Profile(){
		
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

	public void setProfilePicture() {
		System.out.println("Is the picture saved in the file structure? (y/n)");
		Scanner input = new Scanner(System.in);
		String response = input.next();

		if(response.equals("y")) {
			System.out.println("Good! Now please enter the name of your picture file. (include .jpg, .png, etc.)");
			response = input.next();

			try {
				this.profilePicture = ImageIO.read(new File(response));

				/*
				 * This section will need to be changed once the server is set up to something more like:
				 * try {
				 * 		URL url = new URL(getCodeBase(), "pictures/sobble_is_best.png");
				 * 		img = ImageIO.read(url);
				 * }catch(IOException e){
				 * 		System.out.println("The picture you specified seems to be unavailable, please try again");
				 * }
				 */

				System.out.println("Your profile picture was added successfuly! The following picture will be displayed.");
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(new GridLayout(1, 1));
				ImagePanel panel = new ImagePanel(this.profilePicture);
				frame.getContentPane().add(panel);
				frame.pack();
				frame.setVisible(true);
			}
			catch(IOException e) {
				System.out.println("The file name you specified was invalid, please try again");
			}
		}
	}

	/**
	 * Sets the Spirit Animal section of the profile.
	 *
	 * @param spiritAnimal
	 * 		The spirit animal to be added.
	 * 		This can be anything, including an empty string
	 */
	public void setSpiritAnimal(String spiritAnimal) {
		System.out.println("You have entered your spirit animal as: " + (spiritAnimal.trim().equals("") ? "<blank>" : spiritAnimal));

		this.spiritAnimal = spiritAnimal;
	}

	/**
	 * Get the spirit animal section of the profile.
	 */
	public String getSpiritAnimal() {
		return this.spiritAnimal;
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
