package com.rj.jonas.core;
import static com.rj.jonas.core.DriverFactory.killDriver;
import org.junit.After;

public class BaseTest {
	
	@After
	public void finaliza(){
		if(Properties.FECHAR_BROWSER) {
			killDriver();
		}
	}

}