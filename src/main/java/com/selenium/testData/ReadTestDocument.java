package com.selenium.testData;

import org.apache.log4j.Logger;

import com.aspose.cells.Cells;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

public class ReadTestDocument {
	
	Logger _LOGGER = Logger.getLogger(ReadTestDocument.class);
	private int row;
	private int column;
	private String[][] data = null;
	
	public String[][] getTestData(Workbook WB, String sheetName) 
	{
		Worksheet testSheet = WB.getWorksheets().get(sheetName);
		Cells testCell = testSheet.getCells();
		row = testCell.getMaxDataRow();
		column = testCell.getMaxDataColumn()+1;
		
		data = new String[row][column];
		
		_LOGGER.info("Test data sheet name : " + sheetName);
		_LOGGER.info("Row count : " + row + "\tColumn count : " + column);
		
		_LOGGER.info("List of test data for the TestCase");
		for (int i=1;i<=row;i++)
		{
			_LOGGER.info("----------------------Test Data set - " + i + "----------------------");
			for (int j=0;j<column;j++)
			{
				data[i-1][j] = testCell.get(i, j).getValue().toString().replace(".0", "");
				_LOGGER.info("\t" + testCell.get(0, j).getValue().toString() + " : " + data[i-1][j]);
			}
		}
		
		return data;		
	}

}
