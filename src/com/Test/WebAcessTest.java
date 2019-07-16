package com.Test;

import org.testng.annotations.Test;

import com.nmcportal.Putty;

public class WebAcessTest {
	@Test

	public void f() throws Throwable {

		Putty putty = new Putty();

		putty.RunScript(1, "cd /DS;cd Scripts;sh CheckTerm-Pep-Versions.sh -s J1 -g SLC");

	}
}
