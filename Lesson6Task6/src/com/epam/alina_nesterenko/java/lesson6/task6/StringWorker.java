package com.epam.alina_nesterenko.java.lesson6.task6;

public class StringWorker 
{
	public static String [] stringToWords(String stringToSort)
	{
		String [] words = stringToSort.replace(".", "").replace(",", "").replace("?", "").replace("!","").split(" ");
		return words;
	}
}
