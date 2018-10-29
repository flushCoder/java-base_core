package com.cx.controller.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

@Controller
@RequestMapping("/poiExcel")
public class POIController {


    public static void main(String[] args) throws Exception {

        Workbook wb = new HSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet1 = wb.createSheet("sheet1");
        Sheet sheet2 = wb.createSheet("sheet2");
        Row row = sheet1.createRow(0);
        Cell cell = row.createCell(0);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);
        OutputStream os = new FileOutputStream("C:\\Users\\tn-13\\Desktop\\poi\\wb.xlsx");
        wb.write(os);

    }



}
