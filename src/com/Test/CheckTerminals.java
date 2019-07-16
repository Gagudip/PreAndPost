package com.Test;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.nmcportal.ExcelReader;
import com.nmcportal.Putty;

public class CheckTerminals {
	@Test
	public void f() throws Throwable {

		Putty putty = new Putty();

		ExcelReader er = new ExcelReader();

		HashMap<String, String> mp = (HashMap<String, String>) er.GetData(0);

		System.out.println(mp.get("system"));
		System.out.println(mp.get("gateway"));

		String code = "cd /DS;cd Scripts;sh CheckTerm-Pep-Versions.sh -s " + mp.get("system") + " -g "
				+ mp.get("gateway");

		putty.RunScript(4, code);

	}
}
