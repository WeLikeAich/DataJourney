package models;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.Game;
import Utilities.InputValidator;

public class RecoverySpring extends Room {

	public RecoverySpring(Room room) {
		super(room);
	}

	@Override
	public void generateEvent(Party party) {

		do {
			System.out.println(generateEventDialogue());
			int choice = InputValidator.readMenuChoice(2);

			switch(choice) {
			case 1:
				recover(party);
				break;
			case 2:
				do {
					System.out.println("Choose the hero to revive.");
					System.out.println(party.showStatus(true));
					System.out.println("Enter (5) to go to previous menu");
					int reviveChoice = InputValidator.readMenuChoice(5);

					if(reviveChoice == 5 ) 
						break;

					Character charToRevive = party.getMembers()[reviveChoice-1];

					if(charToRevive.isAlive()) {
						System.out.println("That hero is already alive.");
					}
					else {
						revive(charToRevive);
					}
				}while(!HasBeenActivated);
			}
		}while(!HasBeenActivated);
	}

	private void revive(Character target) {
		target.isAlive = true;
		target.Health = target.MaxHealth / 2;

		HasBeenActivated = true;
	}

	private void recover(Party party) {		
		for(Character target : party.getMembers())
		{
			if (!target.isAlive)
				continue;

			target.Health += target.MaxHealth * .25;

			if (target.Health > target.MaxHealth)
				target.Health = target.MaxHealth;
		}

		HasBeenActivated = true;
	}

	@Override
	protected String generateEventDialogue() {
		StringBuilder sb = new StringBuilder();

		sb.append("You have discovered a Recovery Spring:\n");
		sb.append("\t(1)Restore 25% health to the party\n");
		sb.append("\t(2)Revive a fallen hero.");

		return sb.toString();
	}
}
