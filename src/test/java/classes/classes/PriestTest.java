package test.java.classes.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.models.Knight;
import main.java.models.Monk;
import main.java.models.Priest;
import main.java.models.Rogue;

@DisplayName("Priest")
public class PriestTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testPriest() {
		Priest test = new Priest();
		
		assertEquals("Priest", test.getName());
	}

	@Test
	public void testPriestString() {
		String knightName = "knightName";
		Priest test = new Priest(knightName);
		
		assertEquals(knightName, test.getName());
	}

	@Test
	public void testAttackKnight() {
		Priest test = new Priest();
		Knight target = new Knight();
		
		test.attack(target);
		
		assertEquals(target.getMaxHealth(), target.getHealth());
	}

	@Test
	public void testAttackPriest() {
		Priest test = new Priest();
		Priest target = new Priest();
		
		test.attack(target);
		
		assertEquals(93, target.getHealth());
	}

	@Test
	public void testAttackRogue() {
		Priest test = new Priest();
		Rogue target = new Rogue();
		
		test.attack(target);
		
		assertEquals(75, target.getHealth());
	}

	@Test
	public void testAttackMonk() {
		Priest test = new Priest();
		Monk target = new Monk();
		
		test.attack(target);
		
		assertEquals(116, target.getHealth());
	}

	@Test
	public void testUseSpecialKnightFullHealth() {
		Priest test = new Priest();
		Knight target = new Knight();
		
		test.useSpecial(target);
		
		assertEquals(target.getMaxHealth(), target.getHealth());
	}
	
	@Test
	public void testUseSpecialKnightWillRecoverFullHealth() {
		Priest test = new Priest();
		Knight target = new Knight();
		target.takeDamage(20);
		
		test.useSpecial(target);
		
		assertEquals(target.getMaxHealth(), target.getHealth());
	}
	
	@Test
	public void testUseSpecialKnightWillRecoverPartialHealth() {
		Priest test = new Priest();
		Knight target = new Knight();
		target.takeDamage(50);
		
		test.useSpecial(target);
		
		assertEquals(100, target.getHealth());
	}

	@Test
	public void testUseSpecialPriestFullHealth() {
		Priest test = new Priest();
		Priest target = new Priest();
		
		test.useSpecial(target);
		
		assertEquals(target.getMaxHealth(), target.getHealth());
	}
	
	@Test
	public void testUseSpecialPriestWillRecoverFullHealth() {
		Priest test = new Priest();
		Priest target = new Priest();
		target.takeDamage(20);
		
		test.useSpecial(target);
		
		assertEquals(target.getMaxHealth(), target.getHealth());
	}
	
	@Test
	public void testUseSpecialPriestWillRecoverPartialHealth() {
		Priest test = new Priest();
		Priest target = new Priest();
		target.takeDamage(50);
		
		test.useSpecial(target);
		
		assertEquals(73, target.getHealth());
	}

	@Test
	public void testUseSpecialRogueFullHealth() {
		Priest test = new Priest();
		Rogue target = new Rogue();
		
		test.useSpecial(target);
		
		assertEquals(target.getMaxHealth(), target.getHealth());
	}
	
	@Test
	public void testUseSpecialRogueWillRecoverFullHealth() {
		Priest test = new Priest();
		Rogue target = new Rogue();
		target.takeDamage(20);
		
		test.useSpecial(target);
		
		assertEquals(target.getMaxHealth(), target.getHealth());
	}
	
	@Test
	public void testUseSpecialRogueWillRecoverPartialHealth() {
		Priest test = new Priest();
		Rogue target = new Rogue();
		target.takeDamage(50);
		
		test.useSpecial(target);
		
		assertEquals(55, target.getHealth());
	}

	@Test
	public void testUseSpecialMonkFullHealth() {
		Priest test = new Priest();
		Monk target = new Monk();
		
		test.useSpecial(target);
		
		assertEquals(target.getMaxHealth(), target.getHealth());
	}
	
	@Test
	public void testUseSpecialMonkWillRecoverFullHealth() {
		Priest test = new Priest();
		Monk target = new Monk();
		target.takeDamage(20);
		
		test.useSpecial(target);
		
		assertEquals(target.getMaxHealth(), target.getHealth());
	}
	
	@Test
	public void testUseSpecialMonkWillRecoverPartialHealth() {
		Priest test = new Priest();
		Monk target = new Monk();
		target.takeDamage(50);
		
		test.useSpecial(target);
		
		assertEquals(96, target.getHealth());
	}

	@Test
	public void testTakeDamageNoShieldWallGreaterThanDefense() {
		Priest test = new Priest();
		
		test.takeDamage(13);
		
		assertEquals(90, test.getHealth());
	}
	
	@Test
	public void testTakeDamageNoShieldWallLessThanEqualToDefense() {
		Priest test = new Priest();
		
		test.takeDamage(3);
		
		assertEquals(test.getMaxHealth(), test.getHealth());
	}
	
	@Test
	public void testTakeDamageWithShieldWall() {
		Knight knight = new Knight();
		Priest test = new Priest();
		
		knight.useSpecial(test);
		
		test.takeDamage(10);
		
		assertEquals(test.getMaxHealth(), test.getHealth());
	}
}
