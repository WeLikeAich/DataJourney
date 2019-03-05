package main.java.models;


public class Party {
	
	public Character[] Members;
	
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

}
