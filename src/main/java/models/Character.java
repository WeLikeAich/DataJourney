package main.java.models;

import java.util.ArrayList;

import main.java.enums.Statuses;

public abstract class Character {

	public String Name;
	public int MaxHealth;
	public int Health;
	public int Physical;
	public int Intelligence;
	public int Defense;
	public String SpecialName;
	public boolean isAlive = true;
	public ArrayList<Statuses> StatusesSet = new ArrayList<>();

	public Character() {
	}

	public Character(String name) {
		Name = name;
	}

	public boolean attack(Character target, int attackDamage) {
		if (!target.isAlive())
			return false;

		if (StatusesSet.contains(Statuses.Focus))
			attackDamage *= 1.5;

		target.takeDamage(attackDamage);
		return true;
	}

	public abstract boolean attack(Character target);
	
	public abstract boolean useSpecial(Character target);
	
	public void takeDamage(int attackAmount) {
		if (StatusesSet.contains(Statuses.StoneWall)) {
			StatusesSet.remove(Statuses.StoneWall);
			return;
		}

		if (attackAmount < Defense)
			return;

		int damage = attackAmount - Defense;

		Health -= damage;

		if (Health <= 0) {
			Health = 0;
			isAlive = false;
		}
	}

	public boolean isAlive() {
		return isAlive;
	}

	public String getName() {
		return Name;
	}

	public int getMaxHealth() {
		return MaxHealth;
	}

	public int getHealth() {
		return Health;
	}

	public String getSpecialName() {
		return SpecialName;
	}

	public ArrayList<Statuses> getStatusesSet() {
		return StatusesSet;
	}

	public void setHealth(int health) {
		Health = health;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void setStatusesSet(ArrayList<Statuses> statusesSet) {
		StatusesSet = statusesSet;
	}

}
