package com.example.disertatie.service;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Iterator;

@Service
public class ImportFileService {
    public void readFromExcelFile(MultipartFile excelFile) {
        try(InputStream inputStream =  new BufferedInputStream(excelFile.getInputStream())) {

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + " ");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + " ");
                            break;
                    }
                }
                System.out.println();
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
