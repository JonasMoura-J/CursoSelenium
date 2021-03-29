package test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.TestCadastro;
import test.TestPopUp;
import test.TestRegraDeNegocioCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TestCadastro.class,
	TestPopUp.class,
	TestRegraDeNegocioCadastro.class
})
public class SuiteTest {
	
}
