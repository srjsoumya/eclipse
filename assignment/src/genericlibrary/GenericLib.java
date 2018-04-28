package genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericLib {

	String path = "resource/testdata.xls";

	/**
	 * It is developed using Apache poi To retrieve Data from Excel sheet
	 * 
	 * @param sheetName
	 *            Take excel file Sheet Name
	 * @param rowNum
	 *            Take excel file Row Number
	 * @param colNum
	 *            Take excel file Column Number
	 * @return String data based on the argument
	 * 
	 * @throws IOException
	 *             if an I/O error occurs
	 * @throws InvalidFormatException
	 * @throws EncryptedDocumentException
	 * 
	 */
	public String getExcelData(String sheetName, int rowNum, int columnNum)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(columnNum).getStringCellValue();
		wb.close();
		return data;
	}

	/**
	 * Method to View the normal phone number into proper formated manner
	 * 
	 * @param number
	 *            Take mobile number as string Value
	 * @return Render the provided mobile number into proper format
	 */
	public String phoneNumber(String number) {
		String result = "";
		int len = number.length();
		for (int i = 0; i < len; i++) {
			char ch = number.charAt(i);
			if (Character.isDigit(ch)) {
				if (i == 0)
					result = "(" + number.charAt(i);
				else if (i == 2)
					result = result + ") " + number.charAt(i);
				else if (i == 6)
					result = result + "-" + number.charAt(i);
				else if (i >= 10)
					break;
				else
					result = result + number.charAt(i);
			}
		}
		return result;
	}

	/**
	 * Method to convert alphanumeric string to numeric string
	 * 
	 * @param onlyNo
	 *            Take Alphanumeric String
	 * @return Give numeric string type
	 */
	public String onlyNumber(String onlyNo) {
		String result = "";
		for (int i = 0; i < onlyNo.length(); i++) {
			char ch = onlyNo.charAt(i);
			if (ch=='-'|| Character.isDigit(ch))
				result += ch;
		}

		return result;

	}
	/**
	 * method take the string data and convert it into decimal format
	 * @param cent the string provided to convert to cent value
	 * @return
	 */
	public String zerocent(String cent) {
		String result = "";
		int flag = 0;
		String number=onlyNumber(cent);
		if(number.length()==0)
			number="0";
		for (int i = number.length() - 1; i >= 0; i--) {
			char ch = number.charAt(i);
			if (flag != 3)
				result = ch + result;
			else {
				result = ch + "." + result;
				flag = 0;
			}
			flag++;
		}
		return result + ",00";
	}

}
