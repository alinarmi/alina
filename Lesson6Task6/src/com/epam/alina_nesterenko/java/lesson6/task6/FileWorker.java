package com.epam.alina_nesterenko.java.lesson6.task6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWorker
{
	private String fileName;
	private String stringFromFile;
	
	
	/* setters and getters */
	public String getFileName() 
	{
		return fileName;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
	public String getStringFromFile() 
	{
		return stringFromFile;
	}
	public void setStringFromFile(String stringFromFile) 
	{
		this.stringFromFile = stringFromFile;
	}
	/* -- setters and getters -- */
	
	
	
	
	
	/* ----------------------------------------------------- */
	
	/*File f = new File(filePathString);
	if(f.exists() && !f.isDirectory()) 
	{ 
	    // do something
	}
	
	// http://stackoverflow.com/questions/1816673/how-do-i-check-if-a-file-exists-in-java
	
	/* ----------------------------------------------------- */
	
	
	/*
	 * Reads file name from console.
	 */
	public void readFileNameFromConsole()
	{
		Scanner readFileNameFromConsole = new Scanner (System.in);
			
		boolean isFileNameEmpty = true;
		
		while(isFileNameEmpty)
		{
			System.out.println("Input file name (with full path):");
			this.fileName = readFileNameFromConsole.nextLine();
			
			if(this.fileName.isEmpty())
			{
				System.out.println("You entered nothing. Try again.");				
			}
			else
			{
				isFileNameEmpty = false;
			}
		}
		readFileNameFromConsole.close();
	}
	
	public void readFileToString() throws IOException
	{				
		try(BufferedReader br = new BufferedReader(new FileReader(this.fileName))) 
		{
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) 
		    {
		        sb.append(line);
		        //sb.append(System.lineSeparator());
		        sb.append(' ');
		        line = br.readLine();
		    }
		   this.stringFromFile = sb.toString();
		}
	}
}
