package es.studium.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessScanner {
	private List<String> applications32Bit;
	private List<String> applications64Bit;

	public ProcessScanner() {
		// Store 32 and 64 bit application names
		applications32Bit = new ArrayList<>();
		applications64Bit = new ArrayList<>();
	}

	public void findApplications() {

		// PC routes
		String path32Bit = "C:\\Program Files (x86)";
		String path64Bit = "C:\\Program Files";

		findApplicationsInFolder(path32Bit, applications32Bit);
		findApplicationsInFolder(path64Bit, applications64Bit);
	}

	// Looks for applications in the specified folder and adds their 
	// names to the list if they are directories and considered executable
	private void findApplicationsInFolder(String folderPath, List<String> appNames) {
		File folder = new File(folderPath);

		if (folder.isDirectory()) {
			File[] files = folder.listFiles();

			if (files != null) {
				for (File file : files) {
					if (file.isDirectory() && isExecutable(file)) {
						appNames.add(file.getName());
					}
				}
			}
		}
	}

	// Check if a directory contains executable files
	// Iterates through the files in the directory and 
	// returns true if it finds at least one executable file
	private boolean isExecutable(File directory) {

		if (directory.isDirectory()) {
			File[] files = directory.listFiles();

			if (files != null) {
				for (File file : files) {
					if (file.isFile() && file.canExecute()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// Methods needed to allow other parts of the code to access and
	// obtain the information stored in these lists (View: scanview)
	public List<String> getApplications32Bit() {
		return applications32Bit;
	}

	public List<String> getApplications64Bit() {
		return applications64Bit;
	}

	// It receives the name of the selected application as a parameter,
	// creates a process, and runs it via the command line.
	public void executeApp(String selectedItem) {

		try {
			Process pr = Runtime.getRuntime().exec("cmd /c start " + selectedItem);		

			// Also check if the execution completed successfully or if there were any errors.
			int error = pr.waitFor();

			if (error == 0) {
				System.out.println("Executed app: " +selectedItem);
			} else {
				System.out.println("Something went wrong " +error);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
