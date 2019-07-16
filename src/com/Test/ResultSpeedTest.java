package com.Test;

import org.testng.annotations.Test;

import com.nmcportal.NMC;

public class ResultSpeedTest {
  @Test
  public void f() throws Throwable {
	  
	  NMC nmc = new NMC();

		nmc.DriverInitialize();

		nmc.Request("May I get speed test results for list of sans ");

		nmc.Takescreenshot("TerminalStats_");
		
		nmc.WriteExcel(6, null, 9, 6);

  }
}