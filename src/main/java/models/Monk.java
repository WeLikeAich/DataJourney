package main.java.models;

import main.java.enums.Statuses;

public class Monk extends Character {

	public Monk() {
		this("Monk");
	}

	public Monk(String name) {
		Name = name;
		MaxHealth = 120;
		Health = 120;
		Physical = 17;
		Intelligence = 15;
		Defense = 6;
		SpecialName = "Focus";
	}

	public boolean attack(Character target) {

		if (attack(target, Physical)) {
			return true;
		}

		return false;

	}

	public boolean useSpecial() {
		if (!StatusesSet.contains(Statuses.Focus))
			StatusesSet.add(Statuses.Focus);

		return true;
	}

}