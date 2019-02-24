package models;

import java.util.ArrayList;

import enums.Statuses;

public class Priest extends Character {
	
	public Priest(String name) {
		this(1, name);
	}
	
	public Priest(int level, String name) {
		super(level, name);
		
		Intelligence *= 1.2;
		Defense *= .6;
		
		HealthLevelUpChance = 25;
		PhysicalLevelUpChance = 15;
		IntelligenceLevelUpChance = 75;
		DefenseLevelUpChance = 20;
		
		SpecialName = "Holy Light";
	}

	@Override
	protected int levelUp() {
		int chanceRoll = super.levelUp();
		
		if(IntelligenceLevelUpChance >= chanceRoll)
			Intelligence += 2;
		
		return chanceRoll;
	}
	
	@Override
	boolean attack(Character target) {
		// TODO Auto-generated method stub
		return attack(target, (int)(Intelligence * .5));
	}

	@Override
	boolean useSpecial(Character target) {
		if(SpecialCooldownCounter != 0)
			return false;
		
		target.Health += (10 + Level + (Intelligence));
		
		if (target.Health > target.MaxHealth)
			target.Health = target.MaxHealth;
		
		SpecialCooldownCounter = SpecialCooldownResetValue;
		
		return true;
	}
}
