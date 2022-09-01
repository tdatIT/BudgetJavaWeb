package com.datit.file;

import com.datit.dao.BudgetDao;
import com.datit.model.Budget;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class WriteFile {
    public static XSSFWorkbook createExcelFile(int user_id, Date date) {
        //get data from database
        BudgetDao dao = new BudgetDao();
        List<Budget> data = dao.sortByDate(user_id,date);
        //export data into file excel
        XSSFWorkbook file = new XSSFWorkbook();
        try {
            XSSFSheet sheet = file.createSheet();
            //row
            int rowsNo = 0;
            int cellsNo=0;
            Row row = sheet.createRow(rowsNo++);
            //Col STT
            Cell cell = row.createCell(cellsNo++);
            cell.setCellValue("STT");
            //Col Title
            cell = row.createCell(cellsNo++);
            cell.setCellValue("Title");
            //Col Value
            cell = row.createCell(cellsNo++);
            cell.setCellValue("Value");
            //Col create_day
            cell = row.createCell(cellsNo++);
            cell.setCellValue("Create day");
            //Col type
            cell= row.createCell(cellsNo++);
            cell.setCellValue("Type");
            //data rows
            int index=0;
            for(Budget bg: data){
                cellsNo = 0;
                row = sheet.createRow(rowsNo++);

                cell = row.createCell(cellsNo++);
                cell.setCellValue(index++);
                //Col Title
                cell = row.createCell(cellsNo++);
                cell.setCellValue(bg.getTitle());
                //Col Value
                cell = row.createCell(cellsNo++);
                cell.setCellValue(bg.getValue());
                //Col create_day
                cell = row.createCell(cellsNo++);
                cell.setCellValue(bg.getCreateDay());
                //Col type
                cell= row.createCell(cellsNo++);
                switch (bg.getType()){
                    case 1:
                        cell.setCellValue("Thu");
                        break;
                    case 2:
                        cell.setCellValue("Chi");
                        break;
                    case 3:
                        cell.setCellValue("Kế hoạch");
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return file;
    }
}