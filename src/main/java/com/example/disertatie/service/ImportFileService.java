package com.example.disertatie.service;

import com.example.disertatie.domain.User;
import com.example.disertatie.repository.UserRepository;
import org.apache.poi.hpsf.Decimal;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ImportFileService {

    @Autowired
    private UserRepository userRepository;

    public void readFromExcelFile(MultipartFile excelFile) {
        try(InputStream inputStream =  new BufferedInputStream(excelFile.getInputStream())) {

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                User user = new User();
                Row row = rowIterator.next();

                user.setFirstname(row.getCell(0).toString());
                user.setLastname(row.getCell(1).toString());
                user.setAge((int)Float.parseFloat(row.getCell(2).toString()));
                user.setCnp(row.getCell(3).toString());

                userRepository.save(user);


                //For each row, iterate through all the columns
//                Iterator<Cell> cellIterator = row.cellIterator();

//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    switch (cell.getCellType()) {
//                        case NUMERIC:
//                            System.out.print(cell.getNumericCellValue() + " ");
//                            break;
//                        case STRING:
//                            System.out.print(cell.getStringCellValue() + " ");
//                            break;
//                    }
//                }
              //  System.out.println();
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
