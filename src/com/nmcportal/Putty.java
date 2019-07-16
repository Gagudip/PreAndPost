package com.nmcportal;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import ch.ethz.ssh2.Connection;

import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class Putty extends ExcelWriter {

	String hostname = "172.16.37.142";
	

	public void RunScript(int sheet, String Script) throws Throwable {
		

		int counter = 0;

		try {
			
			ExcelReader er = new ExcelReader();
			
		   HashMap<String, String>	mp = (HashMap<String, String>) er.GetData(1);
			
			
			Connection conn = new Connection(hostname);
			
			
			conn.connect();

			boolean isAuthenticated = conn.authenticateWithPassword(mp.get("Username"), mp.get("Password"));

			if (isAuthenticated == false)
				throw new IOException("Authentication failed.");

			Session sess = conn.openSession();

			sess.execCommand(Script);

			System.out.println("Here is some information about the remote host:");

			InputStream stdout = new StreamGobbler(sess.getStdout());

			BufferedReader br = new BufferedReader(new InputStreamReader(stdout));

			while (true) {

				String line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
				WriteTimeStamp(sheet, line, counter);
				counter++;

			}

			System.out.println("ExitCode: " + sess.getExitStatus());

			sess.close();

			conn.close();

		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(2);
		}
	}
}
