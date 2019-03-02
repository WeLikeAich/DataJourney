package test.java.classes.characterTypes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.enums.Statuses;
import main.java.models.Knight;
import main.java.models.Monk;
import main.java.models.Priest;
import main.java.models.Rogue;

@DisplayName("Monk")
public class MonkTest {
	
	@Test
	public void testMonk() {
		Monk test = new Monk();
		
		assertEquals("Monk", test.getName());
	}

	@Test
	public void testMonkString() {
		String monkName = "monkName";
		Monk test = new Monk(monkName);
		
		assertEquals(monkName, test.getName());
	}

	@Test
	public void testAttackKnight() {
		Monk test = new Monk();
		Knight target = new Knight();
		
		test.attack(target);
		
		assertEquals(113, target.getHealth());
	}

	@Test
	public void testAttackPriest() {
		Monk test = new Monk();
		Priest target = new Priest();
		
		test.attack(target);
		
		assertEquals(86, target.getHealth());
	}

	@Test
	public void testAttackRogue() {
		Monk test = new Monk();
		Rogue target = new Rogue();
		
		test.attack(target);
		
		assertEquals(68, target.getHealth());
	}

	@Test
	public void testAttackMonk() {
		Monk test = new Monk();
		Monk target = new Monk();
		
		test.attack(target);
		
		assertEquals(109, target.getHealth());
	}

	@Test
	public void testAttackKnightWithFocus() {
		Monk test = new Monk();
		Knight target = new Knight();
		
		test.useSpecial();
		test.attack(target);
		
		assertEquals(105, target.getHealth());
	}

	@Test
	public void testAttackPriestWithFocus() {
		Monk test = new Monk();
		Priest target = new Priest();
		
		test.useSpecial();
		test.attack(target);
		
		assertEquals(78, target.getHealth());
	}

	@Test
	public void testAttackRogueWithFocus() {
		Monk test = new Monk();
		Rogue target = new Rogue();
		
		test.useSpecial();
		test.attack(target);
		
		assertEquals(60, target.getHealth());
	}

	@Test
	public void testAttackMonkWithFocus() {
		Monk test = new Monk();
		Monk target = new Monk();
		
		test.useSpecial();
		test.attack(target);
		
		assertEquals(101, target.getHealth());
	}
	
	@Test
	public void testUseSpecialMonk() {
		Monk test = new Monk();
		
		test.useSpecial();
		
		assertEquals(true, test.getStatusesSet().contains(Statuses.Focus));
	}

	@Test
	public void testTakeDamageNoShieldWallGreaterThanDefense() {
		Monk test = new Monk();
		
		test.takeDamage(20);
		
		assertEquals(106, test.getHealth());
	}
	
	@Test
	public void testTakeDamageNoShieldWallLessThanEqualToDefense() {
		Monk test = new Monk();
		
		test.takeDamage(6);
		
		assertEquals(test.getMaxHealth(), test.getHealth());
	}
	
	@Test
	public void testTakeDamageWithShieldWall() {
		Monk test = new Monk();
		Knight testKnight = new Knight();
		
		
		testKnight.useSpecial(test);
		
		test.takeDamage(10);
		
		assertEquals(test.getMaxHealth(), test.getHealth());
	}
	
	@Test
	public void testKnight() {
		Knight test = new Knight();

		assertEquals("Knight", test.getName());
	}

	@Test
	public void testKnightString() {
		String knightName = "knightName";
		Knight test = new Knight(knightName);

		assertEquals(knightName, test.getName());
	}

	@Test
	public void testAttackKnight2() {
		Knight test = new Knight();
		Knight target = new Knight();

		test.attack(target);

		assertEquals(target.getMaxHealth(), target.getHealth());
	}

	@Test
	public void testAttackPriest2() {
		Knight test = new Knight();
		Priest target = new Priest();

		test.attack(target);

		assertEquals(93, target.getHealth());
	}

	@Test
	public void testAttackRogue2() {
		Knight test = new Knight();
		Rogue target = new Rogue();

		test.attack(target);

		assertEquals(75, target.getHealth());
	}

	@Test
	public void testAttackMonk2() {
		Knight test = new Knight();
		Monk target = new Monk();

		test.attack(target);

		assertEquals(116, target.getHealth());
	}

	@Test
	public void testUseSpecialKnight() {
		Knight test = new Knight();
		Knight target = new Knight();

		test.useSpecial(target);

		assertEquals(true, target.getStatusesSet().contains(Statuses.StoneWall));
	}

	@Test
	public void testUseSpecialPriest() {
		Knight test = new Knight();
		Priest target = new Priest();

		test.useSpecial(target);

		assertEquals(true, target.getStatusesSet().contains(Statuses.StoneWall));
	}

	@Test
	public void testUseSpecialRogue() {
		Knight test = new Knight();
		Rogue target = new Rogue();

		test.useSpecial(target);

		assertEquals(true, target.getStatusesSet().contains(Statuses.StoneWall));
	}

	@Test
	public void testUseSpecialMonk1() {
		Knight test = new Knight();
		Monk target = new Monk();

		test.useSpecial(target);

		assertEquals(true, target.getStatusesSet().contains(Statuses.StoneWall));
	}

	@Test
	public void testTakeDamageNoShieldWallGreaterThanDefense1() {
		Knight test = new Knight();

		test.takeDamage(20);

		assertEquals(110, test.getHealth());
	}

	@Test
	public void testTakeDamageNoShieldWallLessThanEqualToDefense1() {
		Knight test = new Knight();

		test.takeDamage(10);

		assertEquals(test.getMaxHealth(), test.getHealth());
	}

	@Test
	public void testTakeDamageWithShieldWall2() {
		Knight test = new Knight();

		test.useSpecial(test);

		test.takeDamage(10);

		assertEquals(test.getMaxHealth(), test.getHealth());
	}
}
