package com.simplilearn.project;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Option {

	public Option() {
		
	}

	public void mainMenu() throws IOException {
		System.out.println("Please select from the below options:");
		System.out.println("1. List all the files");
		System.out.println("2. More Business Operations");
		System.out.println("3. Close the Application");
		
		Scanner main = new Scanner(System.in);
		
		try {	
			int mainOption = main.nextInt();
			
			if (mainOption == 1) {
				option1();
			}
			else if (mainOption == 2) {
				option2();
			}
			else if (mainOption == 3) {
				option3();
			}
			else {
				System.out.println("Choose valid option");
				mainMenu();
			}
		}
		catch (InputMismatchException ex) {
			System.out.println("Choose valid option");
			mainMenu();
		}
		
		main.close();
	}

	public void option1() throws IOException {
		System.out.println("Please enter the root directory");
		
		Scanner path = new Scanner(System.in);
		String filePath = path.nextLine();
		File file = new File(filePath);	
		File[] fileList = file.listFiles();
		
		int i;
		if (file.exists() && fileList.length > 0) {
			for (i=0; i<fileList.length; i++) {
				System.out.println(fileList[i]);
			}
		}
		else {
			System.out.println("No file found");
			mainMenu();
		}
		
		path.close();		
	}

	public void option2() throws IOException {
		Operation opr = new Operation();
		
		System.out.println("Please select from the below Business Level Operations");
		System.out.println("a. Add File");
		System.out.println("b. Delete File");
		System.out.println("c. Search File");
		System.out.println("d. Show Previous Options");
		
		Scanner sub = new Scanner(System.in);
	
		try {
			String subOption = sub.next();
			
			if (subOption.equals("a")) {
				opr.addFile();
			}
			else if (subOption.equals("b")) {
				opr.deleteFile();
			}
			else if (subOption.equals("c")) {
				opr.searchFile();
			}
			else if (subOption.equals("d")) {
				mainMenu();
			}
			else {
				System.out.println("Choose valid option");
				option2();
			}			
		}
		catch (InputMismatchException ex) {
			System.out.println("Choose valid option");
			option2();
		}
		
		sub.close();
	}

	public void option3() {
		System.out.println("Thank you for using the Application");
	}
	
}
