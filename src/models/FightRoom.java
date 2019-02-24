package models;

import java.util.ArrayList;
import Utilities.InputValidator;

public class FightRoom extends Room {

	private int difficultyModifier = 1;
	
	public FightRoom() {
		super();
		
		enemies = new Party(generateEnemies());
	}

	public FightRoom(Room room) {
		super(room);

		enemies = new Party(generateEnemies());
	}
	
	public FightRoom(Room room, int difficultyBoost) {
		super(room);

		enemies = new Party(generateEnemies());
	}

	private Party enemies;
	private int possibleExperienceGain = 0;
	private ArrayList<Character> fightOrder = new ArrayList<Character>();
	private boolean finished = false;

	@Override
	public void generateEvent(Party playerParty) {
		HasBeenActivated = true;
		generateInitialFightOrder(playerParty);
		System.out.println(generateEventDialogue());

		do {
			for(Character character : fightOrder) {
				if(!character.isAlive) {
					continue;
				}

				System.out.println("It is " + character.Name + "'s turn.");
				boolean playerTurn = false;
				for(Character playerCharacter : playerParty.getMembers()) {
					if(playerCharacter == character) {
						playerTurn = true;
						break;
					}
				}
				if(playerTurn) {
					//player turn
					boolean actionSuccessful = false;
					do {
						System.out.println(showBattleMenuActionSelection());
						int actionChoice = InputValidator.readMenuChoice(2);

						System.out.println(showBattleMenuTargetSelection());
						int targetChoice = InputValidator.readMenuChoice(fightOrder.size());

						if(actionChoice == 1) {
							Character target = fightOrder.get(targetChoice-1);
							System.out.println(character.Name + " is attacking " + target.Name);
							actionSuccessful = character.attack(target);
						}
						else {
							Character target = fightOrder.get(targetChoice-1);
							System.out.println(character.Name + " is using " + character.SpecialName + " on " + target.Name);
							actionSuccessful = character.useSpecial(fightOrder.get(targetChoice-1));
						}

						if(!actionSuccessful)
						{
							System.out.println("Unable to perform that action.");
						}
					}while(!actionSuccessful);
				}
				else {
					boolean actionSuccessful = false;
					do {

						int targetChoice = (int)(Math.random()*(playerParty.getMembers().length));
						
						Character target = fightOrder.get(targetChoice);
						System.out.println(character.Name + " is attacking " + target.Name);
						actionSuccessful = character.attack(target);

						if(!actionSuccessful)
						{
							System.out.println("Unable to perform that action.");
						}
					}while(!actionSuccessful);
				}
				character.decrementSpecialCounter();
				if(character.SpecialCooldownCounter == 0)
					System.out.println(character.Name + "'s special is ready.");

				if(!enemies.partyIsAlive()) {
					System.out.println("You have been victorious.");
					finished = true;
					break;
				}
				
				if(!playerParty.partyIsAlive()) {
					return;
				}
			}
		}while(!finished);

		for (Character character : playerParty.getMembers()) {
			character.resetStatus();
			boolean leveledUp = character.addExperience(possibleExperienceGain);

			if(leveledUp) {
				System.out.println(character.Name + " has gained a level!");
			}
		}
	}
 
	@Override
	protected String generateEventDialogue() {
		StringBuilder sb = new StringBuilder();

		sb.append("Prepare for a battle adventurers.\n\n");
		sb.append(enemies.showStatus(false));

		return sb.toString();
	}

	private Character[] generateEnemies(){
		Character[] enemies = new Character[(int) (Math.random()*1)+1];

		for(int enemyIndex = 0; enemyIndex < enemies.length; enemyIndex++) {
			Character enemy = generateEnemy();
			possibleExperienceGain += (enemy.Level*75);
			enemies[enemyIndex] = enemy;
		}
		
		return enemies;
	}

	private Character generateEnemy() {
		int enemyTypeRoll = (int) (Math.random() * 4) + 1;

		switch (enemyTypeRoll)
		{
		case 1:
			return new Knight(RoomLevel,"Knight");
		case 2:
			return new Rogue(RoomLevel,"Rouge");
		case 3:
			return new Monk(RoomLevel, "Monk");
		default:
			return new Priest(RoomLevel, "Priest");
		}
	}

	private void generateInitialFightOrder(Party playerParty) {
		addPartyMembersToFightOrder(playerParty);
		addPartyMembersToFightOrder(enemies);
	}

	private void addPartyMembersToFightOrder(Party party) {
		for(Character character : party.getMembers()) {
			if(character.isAlive) {
				fightOrder.add(character);
			}
		}
	}

	private String showBattleMenuTargetSelection() {
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < fightOrder.size(); i++) {
			Character character = fightOrder.get(i);

			sb.append("(" + (i+1) + ")");
			sb.append(character.getName() + "\n");
			sb.append("Level:" + character.getLevel() + "\n");
			sb.append("Health: " + character.getHealth() + "/" + character.getMaxHealth() + "\n\n");
		}

		return sb.toString();
	}

	private String showBattleMenuActionSelection() {
		StringBuilder sb = new StringBuilder();

		sb.append("Do you want to:\n");
		sb.append("\t(1) Attack:\n");
		sb.append("\t(2) Use Special:\n");

		return sb.toString();
	}
}
