import java.io.IOException;
import java.util.Map;


public class check   
{

	public static excel_utls utls=new excel_utls("C:\\Users\\manik.gupta\\eclipse-workspace\\Framework_Practice\\src\\test\\java\\sample_add.xlsx","Sheet1");
	public static void main(String[] args)
	{
		try 
		{ 
			  
			Map<Object,Object> m=(Map<Object, Object>) utls.testData(utls)[1][0];
			System.out.println(m.get("a"));
			System.out.println(utls.testData(utls)[1][0].getClass());
			System.out.println(utls.testData(utls)[2][0].getClass());
			System.out.println(utls.testData(utls)[3][0]);
				         
			/*
			 * Iterator hmIterator = hm.entrySet().iterator();
			 * 
			 * // Iterate through the hashmap // and add some bonus marks for every student
			 * System.out.println("HashMap after adding bonus marks:");
			 * 
			 * while (hmIterator.hasNext()) { Map.Entry mapElement =
			 * (Map.Entry)hmIterator.next(); int marks = ((int)mapElement.getValue() + 10);
			 * System.out.println(mapElement.getKey() + " : " + marks);
			 */	} 
		catch (IOException e) 
		{
		}
	}
	
}
