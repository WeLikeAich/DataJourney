package main.java.models;

import main.java.enums.Statuses;

public class Knight extends Character {

	public Knight() {
		this("Knight");
	}

	public Knight(String name) {
		Name = name;
		MaxHealth = 120;
		Health = 120;
		Physical = 10;
		Intelligence = 10;
		Defense = 10;
		SpecialName = "Stone Wall";
	}

	public boolean attack(Character target) {

		if (attack(target, Physical)) {
			return true;
		}

		return false;

	}

	public boolean useSpecial(Character target) {
		if (!target.getStatusesSet().contains(Statuses.StoneWall))
			target.getStatusesSet().add(Statuses.StoneWall);

		return true;
	}

}
