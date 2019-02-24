package models;

import java.io.Serializable;

public class Party implements Serializable{
	private Character[] Members;
	
	public Character[] getMembers() {
		return Members;
	}

	public Party(Character character1, Character character2, Character character3, Character character4) {
		Members = new Character[] {
				character1,
				character2,
				character3,
				character4
		};
	}
	
	public Party(Character[] party) {
		Members = party;
	}
	
	public boolean partyIsAlive() {
		boolean isAlive = false;
		for(Character character : Members) {
			if(character.isAlive()) {
				isAlive = true;
				break;
			}
		}
		
		return isAlive;
	}
	
	public String showStatus(boolean forMenu) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < Members.length; i++) {
			Character character = Members[i];
			if(forMenu)
				sb.append("(" + (i+1) + ")");
			sb.append(character.getName() + "\n");
			sb.append(character.getClass().getSimpleName() + "\n");
			sb.append("Level:" + character.getLevel() + "\n");
			sb.append("Health: " + character.getHealth() + "/" + character.getMaxHealth() + "\n\n");
		}
		
		return sb.toString();
	}
}
