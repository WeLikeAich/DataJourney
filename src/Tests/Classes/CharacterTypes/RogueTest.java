package tests.classes.characterTypes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.models.Knight;
import main.models.Monk;
import main.models.Priest;
import main.models.Rogue;

@DisplayName("Rogue")
public class RogueTest {
	
	@Test
	public void testRogue() {
		Rogue test = new Rogue();
		
		assertEquals("Rogue", test.getName());
	}

	@Test
	public void testRogueString() {
		String rogueName = "rogueName";
		Rogue test = new Rogue(rogueName);
		
		assertEquals(rogueName, test.getName());
	}

	@Test
	public void testAttackKnight() {
		Rogue test = new Rogue();
		Knight target = new Knight();
		
		test.attack(target);
		
		assertEquals(110, target.getHealth());
	}

	@Test
	public void testAttackPriest() {
		Rogue test = new Rogue();
		Priest target = new Priest();
		
		test.attack(target);
		
		assertEquals(83, target.getHealth());
	}

	@Test
	public void testAttackRogue() {
		Rogue test = new Rogue();
		Rogue target = new Rogue();
		
		test.attack(target);
		
		assertEquals(65, target.getHealth());
	}

	@Test
	public void testAttackMonk() {
		Rogue test = new Rogue();
		Monk target = new Monk();
		
		test.attack(target);
		
		assertEquals(106, target.getHealth());
	}

	@Test
	public void testUseSpecialKnight() {
		Rogue test = new Rogue();
		Knight target = new Knight();
		
		test.useSpecial(target);
		
		assertEquals(0, target.getHealth());
		assertEquals(false, target.isAlive());
	}

	@Test
	public void testUseSpecialPriest() {
		Rogue test = new Rogue();
		Priest target = new Priest();
		
		test.useSpecial(target);
		
		assertEquals(0, target.getHealth());
		assertEquals(false, target.isAlive());
	}

	@Test
	public void testUseSpecialRogue() {
		Rogue test = new Rogue();
		Rogue target = new Rogue();
		
		test.useSpecial(target);
		
		assertEquals(0, target.getHealth());
		assertEquals(false, target.isAlive());
	}

	@Test
	public void testUseSpecialMonk() {
		Rogue test = new Rogue();
		Monk target = new Monk();
		
		test.useSpecial(target);
		
		assertEquals(0, target.getHealth());
		assertEquals(false, target.isAlive());
	}

	@Test
	public void testTakeDamageNoShieldWallGreaterThanDefense() {
		Rogue test = new Rogue();
		
		test.takeDamage(20);
		
		assertEquals(65, test.getHealth());
	}
	
	@Test
	public void testTakeDamageNoShieldWallLessThanEqualToDefense() {
		Rogue test = new Rogue();
		
		test.takeDamage(5);
		
		assertEquals(test.getMaxHealth(), test.getHealth());
	}
	
	@Test
	public void testTakeDamageWithShieldWall() {
		Rogue test = new Rogue();
		Knight testKnight = new Knight();
		
		testKnight.useSpecial(test);
		
		test.takeDamage(10);
		
		assertEquals(test.getMaxHealth(), test.getHealth());
	}
}
