package com.Test;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.nmcportal.ExcelReader;
import com.nmcportal.Putty;

public class IgmStreamError {
	@Test

	public void f() throws Throwable {
		
		
		
		ExcelReader er = new ExcelReader();

		Putty putty = new Putty();
		
		HashMap<String, String> mp = (HashMap<String, String>) er.GetData(0);

		putty.RunScript(4, "cd /DS;cd Scripts;sh IGM_Stream_Error_Check.sh -s" + mp.get("system") + " -g " + mp.get("gateway"));

	}
}
