//Author : Sujyont Kumar Giri :- Sr. Quality Analyst
package TestSuiteBase;

import Utility.Read_XLSX;

public class SuiteUtility {	
	
	public static boolean checkToRunUtility(Read_XLSX xlsx, String sheetName, String ToRun, String testSuite){
				
		boolean Flag = false;		
		if(xlsx.retrieveToRunFlag(sheetName,ToRun,testSuite).equalsIgnoreCase("y")){
			Flag = true;
		}
		else{
			Flag = false;
		}
		return Flag;		
	}
	//Data To Run
	public static String[] checkToRunUtilityOfData(Read_XLSX xlsx, String sheetName, String ColName){		
		return xlsx.retrieveToRunFlagTestData(sheetName,ColName);		 	
	}
 
	public static Object[][] GetTestDataUtility(Read_XLSX xlsx, String sheetName){
	 	return xlsx.retrieveTestData(sheetName);	
	}
 
	public static boolean WriteResultUtility(Read_XLSX xlsx, String sheetName, String ColName, int rowNum, String Result){			
		return xlsx.writeResult(sheetName, ColName, rowNum, Result);		 	
	}
 
	public static boolean WriteResultUtility(Read_XLSX xlsx, String sheetName, String ColName, String rowName, String Result){			
		return xlsx.writeResult(sheetName, ColName, rowName, Result);		 	
	}
	
}

