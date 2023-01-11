package com.ebay.utilities;

import java.util.ArrayList;

public class TestUtil {

	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel(String Sheetname) {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader=new
					Xls_Reader("C:\\Users\\Tathagat\\eclipse-workspace\\ebay\\src\\main\\java\\com\\ebay\\testData\\MobileName.xlsx");

		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int rowNum = 2; rowNum <= reader.getRowCount(Sheetname); rowNum++) {

			if (Sheetname.equals("Services")) // 1
			{
				String MName = reader.getCellData("Services", "MName", rowNum);
				System.out.println(MName);
				
//				String ServicesName = reader.getCellData("Services", "ServicesName", rowNum);
//				System.out.println(ServicesName);
				
				Object ob[] = {MName};
				myData.add(ob);
			}



			else {
				String caller = reader.getCellData("dataclose", "caller", rowNum);
				String shortdiscription = reader.getCellData("dataclose", "shortdiscription", rowNum);
				String CloseData = reader.getCellData("dataclose", "resolvenotes", rowNum);

				System.out.println(shortdiscription);

				Object ob3[] = { caller, shortdiscription, CloseData };
				myData.add(ob3);
			}

		}
		return myData;

	}

}