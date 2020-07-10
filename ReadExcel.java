package utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcelData(String excelFileName) throws IOException {
		XSSFWorkbook book= new XSSFWorkbook("./testdata/"+excelFileName+".xlsx");
		XSSFSheet sheet=book.getSheetAt(0);
		int rowcount= sheet.getLastRowNum();
		System.out.println(rowcount);
		XSSFRow HeaderRow= sheet.getRow(0);
		int colcount= HeaderRow.getLastCellNum();
		String[][] array= new String[rowcount][colcount];
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row= sheet.getRow(i);
			for (int j = 0; j <colcount; j++) {
				XSSFCell cell= row.getCell(j);
				String data1= cell.getStringCellValue();
				array[i-1][j]=data1;
				System.out.println(data1);
				
				
			}
			
		}
		book.close();
		return array;
		
		
		
	}

}
