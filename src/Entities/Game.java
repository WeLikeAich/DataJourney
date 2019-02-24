package Entities;

import java.io.Serializable;
import java.util.Scanner;

import models.BossRoom;
import models.FightRoom;
import models.Knight;
import models.Monk;
import models.Priest;
import models.RecoverySpring;
import models.Rogue;
import models.Room;
import models.Party;
import GameSystem.GameSystem;
import Utilities.InputValidator;

public class Game implements Serializable{
	Party Party;
	Room CurrentRoom;
	BossRoom BossRoom;
	int BossRoomLevel;
	
	public Game() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a name for you're Knight");
		String knightName = scan.nextLine();
		System.out.println("Please enter a name for you're Priest");
		String priestName = scan.nextLine();
		System.out.println("Please enter a name for you're Rogue");
		String rogueName = scan.nextLine();
		System.out.println("Please enter a name for you're Monk");
		String monkName = scan.nextLine();
		
		Party = new Party(
				new Knight(knightName),
				new Priest(priestName),
				new Rogue(rogueName),
				new Monk(monkName));

		generateMap();
	}
	
	public void start() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			if(!CurrentRoom.getHasBeenActivated()) {
				CurrentRoom.generateEvent(Party);
			}
			
			System.out.println(generateMenu());
			int choice = InputValidator.readMenuChoice(6);
			
			switch(choice) {
			case 1:
				moveLeft();
				break;
			case 2:
				moveRight();
				break;
			case 3:
				movePrevious();
				break;
			case 4:
				System.out.println(Party.showStatus(false));
				break;
			case 5:
				GameSystem.save(this);
				System.out.println("Game Saved");
				break;
			case 6:
				return; 
			}
			
			if(!Party.partyIsAlive()) {
				System.out.println("Game Over");
				return;
			}
			else if(Party.partyIsAlive() && CurrentRoom.equals(BossRoom)) {
				System.out.println("Congratulations! You have completed Data Quest");
				return;
			}
		}
	}
	
	private void generateMap() {
		CurrentRoom = new FightRoom();
		generateNextRooms(CurrentRoom);
	}
	
	private void generateNextRooms(Room room) {
		if(room == BossRoom)
			return;
		
		generateLeftRoom(room);
		generateRightRoom(room);
		
		//recursively generate the rooms
		generateNextRooms(room.getLeftRoom());
		generateNextRooms(room.getRightRoom());
	}
	
	private void generateLeftRoom(Room room) {
		room.setLeftRoom(generateNewRoom(room));
	}
	
	private void generateRightRoom(Room room) {
		room.setRightRoom(generateNewRoom(room));
	}
	
	private Room generateNewRoom(Room room) {
		if(room.getRoomLevel() == 15) {
			if (BossRoom == null)
				return BossRoom = new BossRoom(room);
			else
				return BossRoom;
		}
		else {
			int rollChance = (int) (Math.random() * 80) + 1;
			
			if(rollChance % 6 == 0)
				return new RecoverySpring(room);
			else
				return new FightRoom(room);
		}
	}
	
	private String generateMenu() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("What do you want to do?\n");
		sb.append("\t(1) Go Through The Left Door\n");
		sb.append("\t(2) Go Through The Right Door\n");
		sb.append("\t(3) Go Through The Previous Door\n");
		sb.append("\t(4) Show Status\n");
		sb.append("\t(5) Save\n");
		sb.append("\t(6) Quit\n");
		
		return sb.toString();
	}
	
	private void moveLeft() {
		CurrentRoom = CurrentRoom.getLeftRoom();
	}
	
	private void moveRight() {
		CurrentRoom = CurrentRoom.getRightRoom();
	}
	
	private void movePrevious() {
		Room previousRoom = CurrentRoom.getPreviousRoom();
		
		if(previousRoom != null)
			CurrentRoom = CurrentRoom.getPreviousRoom();
		else
			System.out.println("You are in the starting room. There is no previous room to enter.");
	}
}