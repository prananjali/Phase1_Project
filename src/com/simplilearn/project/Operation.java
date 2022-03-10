package com.simplilearn.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Operation {

	public Operation() {
		
	}

	public void addFile() throws IOException {
		System.out.println("Please enter the folder in which file has to be added");
		Scanner dir = new Scanner(System.in);
		String directory = dir.nextLine();
		
		System.out.println("Please enter the file name");
		Scanner fileName = new Scanner(System.in);
		String addFile = fileName.nextLine();
		
		System.out.println("Please enter the data to be added in the file");
		Scanner text = new Scanner(System.in);
		String data = text.nextLine();
		
		File folder = new File(directory);
		folder.mkdir();
		
		try {
			File newFile = new File(directory+"/"+addFile);
			FileWriter fw = new FileWriter(newFile);
			fw.write(data);
			fw.close();
			
			System.out.println(addFile+" is added successfully");
		}
		catch (FileNotFoundException nf) {
			System.out.println("Invalid folder or file name");
			addFile();
		}
		
		dir.close();
		fileName.close();
		text.close();		
	}

	public void deleteFile() {
		System.out.println("Please enter the folder from which the file has to be deleted");
		Scanner dir = new Scanner(System.in);
		String directory = dir.nextLine();
		
		System.out.println("Please enter the file name");
		Scanner fileName = new Scanner(System.in);
		String deleteFile = fileName.nextLine();
		
		File oldFile = new File(directory+"/"+deleteFile);
		
		if (oldFile.exists() == true) {
			oldFile.delete();
			System.out.println(deleteFile+" is deleted successfully");
		}
		else {
			System.out.println(deleteFile+" not found");
		}
					
		dir.close();
		fileName.close();	
	}

	public void searchFile() {
		System.out.println("Please enter the folder in which the file has to be searched");
		Scanner dir = new Scanner(System.in);
		String directory = dir.nextLine();
		
		System.out.println("Please enter the file name");
		Scanner fileName = new Scanner(System.in);
		String searchFile = fileName.nextLine();
		
		File oldFile = new File(directory+"/"+searchFile);
		
		if (oldFile.exists() == true) {
			System.out.println(searchFile+" found");
		}
		else {
			System.out.println(searchFile+" not found");
		}
		
		dir.close();
		fileName.close();	
	}

}
