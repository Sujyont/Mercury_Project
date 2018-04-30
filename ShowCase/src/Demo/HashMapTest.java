package Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapTest {

	public static void main(String[] args) throws IOException {
		String FilePath = "C:\\Users\\sujyonta.giri\\Desktop\\TestData.xlsx";
		FileInputStream fs = new FileInputStream(FilePath);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet ws = wb.getSheet("Sheet1");
		int columnCount = ws.getRow(0).getLastCellNum();
		int rowCount=ws.getLastRowNum();
		System.out.println("Row Count : "+rowCount);
		System.out.println("Col count : "+columnCount);
		Map<String, List<String>> headingKey = new HashMap<String, List<String>>();
		List<String> valueSet; 
		String heading="";
		String valueSetName="";
		for(int c=0;c<columnCount;c++) {
			Row row = ws.getRow(0);
			heading = row.getCell(c).getStringCellValue();
			System.out.println("Heading :" +heading);
			valueSet = new ArrayList<String>();
			for(int r=1;r<=rowCount;r++) {
				Row row1 = ws.getRow(r);
				Cell cell = row1.getCell(c);
				
				
				if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
				valueSet.add(row1.getCell(c).getStringCellValue());
				}
				else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
					valueSet.add(Double.toString(row1.getCell(c).getNumericCellValue()));	
				}
				else if(cell.getCellType()==Cell.CELL_TYPE_BLANK) {
					valueSet.add("");	
				}
			}//iner for loop
			headingKey.put(heading, valueSet);
			//valueSet.clear();
		}//outer for loop
		 for (Map.Entry<String, List<String>> entry : headingKey.entrySet()) {
	            String key = entry.getKey();
	            List<String> values = entry.getValue();
	            System.out.println("Key = " + key);
	            System.out.println("Values = " + values);
	        }
	
	}//main method

}
