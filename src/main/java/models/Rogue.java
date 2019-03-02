package main.java.models;

public class Rogue extends Character {

	public Rogue() {
		this("Rogue");
	}

	public Rogue(String name) {
		Name = name;
		MaxHealth = 80;
		Health = 80;
		Physical = 20;
		Intelligence = 10;
		Defense = 5;
		SpecialName = "Backstab";
	}

	public boolean attack(Character target) {

		if (attack(target, Physical)) {
			return true;
		}

		return false;
	}

	public boolean useSpecial(Character target) {

		if (target.isAlive()) {
			target.setHealth(0);
			target.setAlive(false);

			return true;
		}

		return false;
	}

}