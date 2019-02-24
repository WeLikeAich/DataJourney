package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import enums.Statuses;

public abstract class Character implements Serializable{
	protected String Name;
	protected int MaxHealth = 100;
	protected int Health = 100;
	protected int Physical = 15;
	protected int Intelligence = 15;
	protected int Defense = 5;
	protected int HealthLevelUpChance;
	protected int PhysicalLevelUpChance;
	protected int IntelligenceLevelUpChance;
	protected int DefenseLevelUpChance;
	protected int SpecialCooldownResetValue = 3;
	protected int SpecialCooldownCounter = 3;
	protected int Level = 1;
	protected int Experience = 0;
	protected int ExperienceForNextLevel = 1000;
	protected List<Statuses> StatusesSet = new ArrayList<>();
	protected String SpecialName;
	protected boolean isAlive = true;
	
	public String getName() {
		return Name;
	}

	public int getMaxHealth() {
		return MaxHealth;
	}

	public int getHealth() {
		return Health;
	}

	public int getLevel() {
		return Level;
	}

	public void setHealth(int health) {
		Health = health;
	}

	protected Character(int level, String name) {
		Name = name;
		for(;Level < level; levelUp());
	}
	
	protected int levelUp() {
		Level++;
		Experience = Experience - ExperienceForNextLevel;
		ExperienceForNextLevel *= 1.2;
	
		int chanceRoll = (int)Math.random()*100;
		
		if(HealthLevelUpChance >= chanceRoll) 
			Health = MaxHealth *= 1.05;
		if(PhysicalLevelUpChance >= chanceRoll) 
			Physical += 1;
		if(IntelligenceLevelUpChance >= chanceRoll) 
			Intelligence += 1;
		if(DefenseLevelUpChance >= chanceRoll) 
			Defense += 1;
		
		return chanceRoll;
	}
	
	public boolean addExperience(int experienceToAdd) {
		Experience += experienceToAdd;
		if(Experience >= ExperienceForNextLevel) {
			levelUp();
			return true;
		}
		return false;
	}
	
	protected boolean attack(Character target, int attackAttribute) {
		if(!target.isAlive())
			return false;
		target.takeDamage(attackAttribute);
		return true;
	}
	
	private void takeDamage(int attackAmount) {
		if(attackAmount < Defense)
			return;
		
		if(StatusesSet.contains(Statuses.StoneWall))
		{
			StatusesSet.remove(Statuses.StoneWall);
			return;
		}
		
		int damage = attackAmount - Defense;
		
		Health -= damage;
		System.out.println(Name + " takes " + damage + " damage");
		
		if(Health <= 0) {
			Health = 0;
			isAlive = false;
		}
	}
	
	public void decrementSpecialCounter() {
		if(SpecialCooldownCounter > 0)
			SpecialCooldownCounter--;
	}
	
	abstract boolean attack(Character target);
	
	abstract boolean useSpecial(Character target);
	
	public String toString() {
		return this.getClass().getSimpleName() + " - Level " + this.Level + "\n Health: " + this.Health + "/" + this.MaxHealth;
	}

	public boolean isAlive() {
		return isAlive;
	}
	
	public void resetStatus() {
		StatusesSet.clear();
	}
}
