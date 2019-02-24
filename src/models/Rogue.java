package models;

import java.util.ArrayList;

import enums.Statuses;

public class Rogue extends Character {

	public Rogue(String name) {
		this(1, name);
	}
	
	public Rogue(int level, String name) {
		super(level, name);
		
		Physical *= 1.2;
		MaxHealth = Health *= .8;
		
		HealthLevelUpChance = 25;
		PhysicalLevelUpChance = 75;
		IntelligenceLevelUpChance = 15;
		DefenseLevelUpChance = 25;
		
		SpecialCooldownResetValue = 5;
		
		SpecialName = "Backstab";
	}
	
	@Override
	protected int levelUp() {
		int chanceRoll = super.levelUp();
		
		if(PhysicalLevelUpChance >= chanceRoll)
			Physical += 2;
		
		return chanceRoll;
	}

	@Override
	boolean attack(Character target) {
		// TODO Auto-generated method stub
		return attack(target, Physical);
	}
	
	@Override
	boolean useSpecial(Character target) {
		if(SpecialCooldownCounter != 0)
			return false;
		
		if(target.equals(this))
			return false;
					
		target.Health = 0;
		target.isAlive = false;
		
		SpecialCooldownCounter = SpecialCooldownResetValue;
		
		return true;
	}
}
