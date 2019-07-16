package com.Test;

import org.testng.annotations.Test;

import com.nmcportal.Jovian;

public class Alarm {
  @Test
  public void f() {
	  
	  Jovian j = new Jovian();
	  
	  
	  j.EM7Alarms("http://172.27.33.220/em7/index.em7?exec=events");
	  
	  
	 j.EM7Alarms("http://172.27.33.182/em7/index.em7?exec=events#");
	  
	  
	  
	  
  }
}
