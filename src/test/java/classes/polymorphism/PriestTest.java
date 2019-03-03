package test.java.classes.polymorphism;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.java.enums.Statuses;
import main.java.models.Character;
import main.java.models.Knight;
import main.java.models.Monk;
import main.java.models.Priest;
import main.java.models.Rogue;

@DisplayName("Priest")
public class PriestTest {

	
	//////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////Tests////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	
	
	@Test
	void testPriest() {
		Character test = new Priest();

		assertEquals("Priest", test.getName());
	}

	@ParameterizedTest(name="Run {index}: testName= {0}")
	@MethodSource("testPriestString_Parameters")
	void testPriestString(String testName) {
		Character test = new Priest(testName);

		assertEquals(testName, test.getName());
	}
	
	
	
	
	

	@ParameterizedTest(name="Run {index}: target= {0}, resultingHealth= {1}")
	@MethodSource("testAttack_Parameters")
	void testAttack(Character target, int resultingHealth) {
		Character test = new Priest();

		test.attack(target);
		
		assertEquals(resultingHealth, target.Health);
	}
	
	
	
	
	@ParameterizedTest(name="Run {index}: target= {0}, initialDamageToTake= {1}, initialDamageToTake= {2}")
	@MethodSource("testUseSpecial_Parameters")
	void testUseSpecial(Character target, int initialDamageToTake, int expectedHealthAfterHealing) {
		Character test = new Priest();

		target.takeDamage(initialDamageToTake);
		
		test.useSpecial(target);
		
		assertEquals(expectedHealthAfterHealing, target.Health);
		
	}
	
	/////////////////////////////////////////////////////////////////////////////
	////////////////////////////////Test Parameters//////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	
	
	static Stream<Arguments> testUseSpecial_Parameters() throws Throwable {
		
		return Stream.of(
				Arguments.of(new Knight(), 10, 120),
				Arguments.of(new Knight(), 40, 110),
				Arguments.of(new Priest(), 10, 100),
				Arguments.of(new Priest(), 33, 90),
				Arguments.of(new Rogue(), 10, 80),
				Arguments.of(new Rogue(), 30, 75),
				Arguments.of(new Monk(), 10, 120),
				Arguments.of(new Monk(), 30, 116)
				);
	}
	
	static Stream<Arguments> testAttack_Parameters() throws Throwable {
		return Stream.of(
				Arguments.of(new Knight(), 120),
				Arguments.of(new Priest(), 93),
				Arguments.of(new Rogue(), 75),
				Arguments.of(new Monk(), 116)
				);
	}
	
	static Stream<Arguments> testPriestString_Parameters() throws Throwable {
		return Stream.of(
				Arguments.of("testName"),
				Arguments.of(""),
				Arguments.of("test name"),
				Arguments.of("125@@#%")
				);
	}
}
