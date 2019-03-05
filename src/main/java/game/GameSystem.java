package main.java.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import main.java.models.Knight;
import main.java.models.Monk;
import main.java.models.Priest;
import main.java.models.Rogue;
import main.java.utilities.InputValidator;
import main.java.models.Character;

public class GameSystem {

	private static String SaveFileName = "SaveFile.txt";

	public static void main(String[] args) {
	
		Character[] party = null;
		boolean quitGame = false;

		while (!quitGame) {

			if (party == null) {

				System.out.println("Do you want to:");
				System.out.println("\t(1) Start A New Game");
				System.out.println("\t(2) Load The Saved Game");
				System.out.println("\t(3) Quit");

				int choice = InputValidator.readMenuChoice(3);

				switch (choice) {
				case 1:
					party = generateParty();
					break;
				case 2:
					party = load();
					break;
				case 3:
					System.out.println("Thank you for playing.");
					System.exit(0);
				}
			}

			if (party != null) {

				System.out.println("Do you want to:");
				System.out.println("\t(1) Start A New Game\n");
				System.out.println("\t(2) Save This Game\n");
				System.out.println("\t(3) Quit");

				int choice = InputValidator.readMenuChoice(3);

				switch (choice) {
				case 1:
					party = generateParty();
					break;
				case 2:
					party = save(party);
					break;
				case 3:
					System.out.println("Thank you for playing.");
					System.exit(0);

				}

			}

		}

	}

	public static Character[] generateParty() {
		Character[] party = new Character[] { new Knight(""), new Monk(""), new Priest(""), new Rogue("") };
		return party;
	}

	public static Character[] save(Character[] party) {
		try {
			FileOutputStream file = new FileOutputStream(SaveFileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(party);

			out.close();
			file.close();
		} catch (IOException e) {
			System.out.println("Unable to save");
			e.printStackTrace();

		}
		
		return null;

	}

	public static Character[] load() {
		Character[] returnParty = null;
		try {
			FileInputStream file = new FileInputStream(SaveFileName);
			ObjectInputStream in = new ObjectInputStream(file);

			returnParty = (Character[]) in.readObject();

			in.close();
			file.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load");
			e.printStackTrace();
		}
		return returnParty;
	}
}
