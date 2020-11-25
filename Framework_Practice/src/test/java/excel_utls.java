
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_utls {


	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public excel_utls(String excelpath,String sheetname)  
	{
		try {
			workbook=new XSSFWorkbook(excelpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetname);
	}
	

	public static int get_row_count()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int get_column_count()
	{
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	
	public static String get_data_String(int row, int column) 
	{
		return sheet.getRow(row).getCell(column).getStringCellValue();
	}
	
	public static double get_data_numeric(int row, int column) 
	{
		return sheet.getRow(row).getCell(column).getNumericCellValue();
	}
	public static Object[][] testData(excel_utls excel) throws IOException
	{
		int row_count=excel.get_row_count();
		int column_count=excel.get_column_count();
		Object data[][]=new Object[row_count-1][1]; 
		for (int i = 1; i < row_count; i++) 
		{

			Map<String,String> hashmap=new HashMap<String, String>();
			for (int j = 0; j < column_count; j++)
			{
				String key=sheet.getRow(0).getCell(j).getStringCellValue();
				//int value=(int) sheet.getRow(i+1).getCell(j).getNumericCellValue();
				//System.out.println(sheet.getRow(i).getCell(j));
				hashmap.put(key,sheet.getRow(i).getCell(j).getStringCellValue());
				/*
				 * String cell_data=excel.get_data_String(i, j); data[i-1][j]=cell_data;
				 * System.out.println(cell_data);
				 */
			}
			data[i-1][0]=hashmap;
		}
	
	  return data;
	}
	
	
			
}



