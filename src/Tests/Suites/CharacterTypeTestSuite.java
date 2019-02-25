package Tests.Suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Character Type Test Suite")
@SelectPackages("Tests.Classes.CharacterTypes")
public class CharacterTypeTestSuite {

}
