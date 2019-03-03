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

@DisplayName("Knight")
public class KnightTest {

	
	//////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////Tests////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	
	
	@Test
	void testKnight() {
		Character test = new Knight();

		assertEquals("Knight", test.getName());
	}

	@ParameterizedTest(name="Run {index}: testName= {0}")
	@MethodSource("testKnightString_Parameters")
	void testKnightString(String testName) {
		Character test = new Knight(testName);

		assertEquals(testName, test.getName());
	}

	@ParameterizedTest(name="Run {index}: target= {0}, resultingHealth= {1}")
	@MethodSource("testAttack_Parameters")
	void testAttack(Character target, int resultingHealth) {
		Character test = new Knight();

		test.attack(target);
		
		assertEquals(resultingHealth, target.Health);
	}
	
	@ParameterizedTest(name="Run {index}: target= {0}, status= {1}")
	@MethodSource("testUseSpecial_Parameters")
	void testUseSpecial(Character target, Statuses status) {
		Character test = new Knight();

		test.useSpecial(target);
		
		assertTrue(target.getStatusesSet().contains(status));
	}
	
	/////////////////////////////////////////////////////////////////////////////
	////////////////////////////////Test Parameters//////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	
	
	static Stream<Arguments> testUseSpecial_Parameters() throws Throwable {
		Statuses status = Statuses.StoneWall;
		
		return Stream.of(
				Arguments.of(new Knight(), status),
				Arguments.of(new Priest(), status),
				Arguments.of(new Rogue(), status),
				Arguments.of(new Monk(), status)
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
	
	static Stream<Arguments> testKnightString_Parameters() throws Throwable {
		return Stream.of(
				Arguments.of("testName"),
				Arguments.of(""),
				Arguments.of("test name"),
				Arguments.of("125@@#%")
				);
	}
}
