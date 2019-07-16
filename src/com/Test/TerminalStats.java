package com.Test;

import org.testng.annotations.Test;

import com.nmcportal.NMC;

public class TerminalStats {
	@Test
	public void f() throws Throwable {

		NMC nmc = new NMC();

		nmc.DriverInitialize();

		nmc.Request("May I get terminal state code, sqf, ipgw, naks for sans ");

		nmc.Takescreenshot("TerminalStats_");
		
		nmc.WriteExcel(7, null, 10, 13);

	}
}
