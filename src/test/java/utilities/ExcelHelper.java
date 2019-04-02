package utilities;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper extends GenericHelper {
	Workbook book;
	Sheet sheet;

	// set an excel file to read the data
	public void setExcel(String folderName, String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(getFilePath(folderName, fileName));
			if (fileName.endsWith("xls")) {
				book = new HSSFWorkbook(fis);
			} else if (fileName.endsWith("xlsx")) {
				book = new XSSFWorkbook();
			}
			sheet = book.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// count the number of rows
	public int rowCount() {
		return sheet.getLastRowNum();
	}

	// count the number of columns
	public int columnCount() {
		return sheet.getRow(1).getLastCellNum();
	}

	// read data from a cell
	public String readData(int rnum, int cnum) {
		Cell cell = sheet.getRow(rnum).getCell(cnum);
		CellType cellType = cell.getCellType();
		String data = null;
		switch (cellType) {
		case NUMERIC:
			Integer i = (int) cell.getNumericCellValue();
			data = i.toString();
			break;
		case STRING:
			data = cell.getStringCellValue();
			break;
		default:
			System.out.println("cell type not supported");
			break;
		}
		return data;
	}

	public String[][] readExcelData(String folderName, String fileName, String sheetName) {
		this.setExcel(folderName, fileName, sheetName);
		int nor = this.rowCount();
		int noc = this.columnCount();
		String[][] data = new String[nor][noc];
		for (int i = 1; i <= nor; i++) {
			for (int j = 0; j < noc; j++) {
				data[i - 1][j] = this.readData(i, j);
			}
		}
		return data;
	}

	public static void main(String[] args) {
		ExcelHelper excel = new ExcelHelper();
		String[][] dt = excel.readExcelData("", "testdata.xls", "roleData");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(dt[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
