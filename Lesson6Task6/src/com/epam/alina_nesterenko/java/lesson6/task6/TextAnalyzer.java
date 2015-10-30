package com.epam.alina_nesterenko.java.lesson6.task6;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class TextAnalyzer 
{		
	public static void main (String [] args) throws IOException
	{
		
		
		FileWorker fw = new FileWorker();
		fw.readFileNameFromConsole();
		fw.readFileToString();
		
		findFrequencyOfWords(fw.getStringFromFile());
		
		//System.out.println("Input operation: 1 - frequency, 2 - length, 3 - duplicates");
	}
	
	private static void findFrequencyOfWords(String stringToSort)
	{		
		// Split string to words.
		String [] words = StringWorker.stringToWords(stringToSort);
				
		// Add all words and their count to map.
		Map<String, Integer> freq = new HashMap<String, Integer>();
		
		for(String item : words)
		{			
			Integer count = freq.get(item);
			if (count == null) {
			    freq.put(item, 1);
			}
			else {
			    freq.put(item, count + 1);
			}
		}
		
		// Print map:
		for (String name: freq.keySet())
		{

            String key =name.toString();
            String value = freq.get(name).toString();  
            System.out.println(key + " " + value);  
		}
		
		
		//--------------------------------------
				 
	    //*value Class should implements the Comparable interface
	    //*String implements Comparable by default.
	 	    
	    System.out.println("Unsorted Map: "+freq);
	    System.out.println("Sorted Map By Values: "+MapSort.sortByValue(freq));
	    System.out.println("Sorted Map By Keys: "+MapSort.sortByKey(freq));
	    
	    
	    
	    
	    // -----------------------------------------------
	    
	    int [] array = {1, 1, 2, 2}; /////////////////////////////////////////////////
		int [] array_res =findTwoHighestDistinctValues(array);
		
		String [] y = getKeysByValue(freq, array_res[0]).toArray(new String[0]);
		String [] y2 = getKeysByValue(freq, array_res[1]).toArray(new String[0]);
		
		for(int i=0; i<y.length; i++)
		{
			System.out.println(y[i]);
		}
		
		for(int i=0; i<y2.length; i++)
		{
			System.out.println(y2[i]);
		}
	    
	  }
	
	/**
     * Finds the highest distinct value (index 0) and second highest distinct value (index 1).
     *         
     */
    public static int[] findTwoHighestDistinctValues(int[] array)
    {
    	// verify if array.length > 0 (!!!)
    	// ...
    	/////
        int max = array[0];
        int secondMax = array[0];

        for (int value:array)
        {
            if (value > max)
            {
                secondMax = max;
                max = value;
            }
            else if (value > secondMax && value < max)
            {
                secondMax = value;
            }
        }
        return new int[] { max, secondMax };
    }
 
    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) 
    {
        Set<T> keys = new HashSet<T>();
        for (Entry<T, E> entry : map.entrySet()) 
        {
            if (Objects.equals(value, entry.getValue())) 
            {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
       
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) 
    {
        for (Entry<T, E> entry : map.entrySet()) 
        {
            if (Objects.equals(value, entry.getValue())) 
            {
                return entry.getKey();
            }
        }
        return null;
    }
} 

