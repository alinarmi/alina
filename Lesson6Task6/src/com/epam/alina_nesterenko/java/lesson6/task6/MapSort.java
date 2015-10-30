package com.epam.alina_nesterenko.java.lesson6.task6;

import java.util.Map;
import java.util.TreeMap;

public class MapSort 
{
	public static Map sortByValue(Map unsortedMap)
	{
	    Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
	    sortedMap.putAll(unsortedMap);
	    return sortedMap;
	}
	
	  public static Map sortByKey(Map unsortedMap)
	  {
	    Map sortedMap = new TreeMap();
	    sortedMap.putAll(unsortedMap);
	    return sortedMap;
	  }
}
