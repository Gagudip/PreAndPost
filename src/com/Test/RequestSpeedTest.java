package com.Test;
import org.testng.annotations.Test;

import com.nmcportal.NMC;

public class RequestSpeedTest {

	@Test
	public void f() throws Throwable {

		NMC nmc = new NMC();

		nmc.DriverInitialize();

		nmc.Request("May I request a speed test to be run for list of sans ");

		nmc.Takescreenshot("RequestSpeedTest_");

		
		System.out.println("Requesting the result of list of sans in 4 mins");
		
		

		
	}
}
