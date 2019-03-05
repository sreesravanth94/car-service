package datamodel;

import java.util.ArrayList;

public class Services {
	
	public String[] getTitle(String newAuto,String fallSpecial,String oilChange,String diagnostic,String wheelAlignment,String airCondition) {
		
		System.out.println(newAuto  + fallSpecial  + oilChange + diagnostic+ wheelAlignment + airCondition);
     
		ArrayList<String> arrlist = new ArrayList<String>();
		// adding element to positions
		
		if(newAuto == null) {	 
		}else 
		{
			arrlist.add("NewAuto");
		}
		if(fallSpecial == null) {	 
		}else 
		{
			arrlist.add("FallSpecial");
		}
		
		if(oilChange== null) {	 
		}
		else 
		{
			arrlist.add("OilChange");
		}
		
		if(diagnostic== null) {	 
		}
		else 
		{
			arrlist.add("New Car Diagnostic");
		}
		
		if(wheelAlignment== null) {	 
		}
		else 
		{
			arrlist.add("WheelAlignment");
		}
		
		if(airCondition== null) {	 
		}
		else 
		{
			arrlist.add("AirCondition");
		}		 
	      
	     System.out.println("Size of list: " + arrlist.size());
	     String[] simpleArray = arrlist.toArray(new String[arrlist.size()]);

	     
	return simpleArray;

}
}
