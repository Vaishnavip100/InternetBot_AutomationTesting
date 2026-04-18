package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtil {
    public static Object[][] getData(String filePath,String sheetName) {
        Object[][] data=null;
        try {
            FileInputStream fis=new FileInputStream(filePath);
            Workbook wb=WorkbookFactory.create(fis);
            Sheet sheet=wb.getSheet(sheetName);

            int rows=sheet.getPhysicalNumberOfRows();
            int cols=sheet.getRow(0).getPhysicalNumberOfCells();

            data=new Object[rows-1][cols];

            for(int i=1;i<rows;i++) {
                Row row=sheet.getRow(i);
                if (row==null) {
                    continue;
                }

                boolean isEmptyRow=true;

                for (int j=0;j<cols;j++) {
                    Cell cell=row.getCell(j);
                    if (cell==null) {
                        data[i-1][j]="";
                    } else {
                        String value=cell.toString().trim();
                        data[i-1][j]=value;
                        if (!value.isEmpty()) {
                            isEmptyRow=false;
                        }
                    }
                }
                if (isEmptyRow) {
                    data[i-1]=new Object[cols];
                    for (int j=0;j<cols;j++) {
                        data[i-1][j]="";
                    }
                }
            }
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}