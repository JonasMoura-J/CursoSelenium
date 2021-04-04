package com.rj.jonas.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.rj.jonas.core.DriverFactory;
import com.rj.jonas.test.TestRegraDeNegocioCadastro;
import com.rj.jonas.test.TesteCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TestRegraDeNegocioCadastro.class
})
public class SuiteTest {
	
	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
}