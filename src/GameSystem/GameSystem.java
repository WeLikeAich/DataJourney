package GameSystem;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import Entities.Game;
import Utilities.InputValidator;

public class GameSystem {

	private static String SaveFileName = "SaveFile.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(generateWelcomeMessage());
		System.out.println(generateStartingMenu());
		
		int choice = InputValidator.readMenuChoice(3);
		
		Game game = null;
		switch(choice) {
			case 1:
				game = new Game();
				break;
			case 2:
				game = load();
				break;
			case 3:
				System.out.println("Thank you for playing.");
				System.exit(0);
		}
		game.start();
			
		System.out.println("Thank you for playing.");
	}

	public static String generateWelcomeMessage() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Welcome to Data Quest\n");
		sb.append("The text based dungeon explorer.\n\n");
		
		
		return sb.toString();
	}
	
	public static String generateStartingMenu() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Do you want to:\n");
		sb.append("\t(1) Start A New Game\n");
		sb.append("\t(2) Load The Saved Game\n");
		sb.append("\t(3) Quit");
		
		return sb.toString();
	}
	
	public static void save(Game game) {
		try {
			FileOutputStream file = new FileOutputStream(SaveFileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(game);
			
			out.close();
			file.close();
		} 
		 catch (IOException e) {
			 System.out.println("Unable to save");
			e.printStackTrace();
		}
		
	}
	
	public static Game load() {
		Game loadedGame = null;
		try {
			FileInputStream file = new FileInputStream(SaveFileName); 
            ObjectInputStream in = new ObjectInputStream(file); 
			
			loadedGame = (Game)in.readObject();
			
			in.close();
			file.close();
		} 
		 catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load");
			 e.printStackTrace();
		}
		return loadedGame;
	}
}
