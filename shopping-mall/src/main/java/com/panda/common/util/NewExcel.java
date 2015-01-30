package com.panda.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class NewExcel {

	/**
	 * 创建Excel
	 * @param title 标题
	 * @param colName 列名
	 * @param data 数据
	 * @param keys 数据MAP的key
	 * @param path 文件生成路径
	 * @return
	 * @throws Exception 
	 */
	public HSSFWorkbook createExcel(String title, String[] headers,
			List<Map<String, Object>> data, String[] keys) throws Exception {
		
		// 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        //循环数据，每10000条一个sheet页
        for(int batch=1;batch<=data.size()/10000+1;batch++){
	        // 生成一个表格
	        HSSFSheet sheet = workbook.createSheet(title+batch+"");
	        // 设置表格默认列宽度为15个字节
	        sheet.setDefaultColumnWidth(20);
	        
	        
	        // 产生表格标题行
	        HSSFRow row = sheet.createRow(0);
	        row.setHeight((short) 400);
	        HSSFCellStyle style = getHeaderStyle(workbook);
	        
	        HSSFCell cell = row.createCell(0);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString("序列");
            cell.setCellValue(text);
            
	        for (int i = 0; i < headers.length; i++) {
	            cell = row.createCell(i+1);
	            cell.setCellStyle(style);
	            text = new HSSFRichTextString(headers[i]);
	            cell.setCellValue(text);
	        }
			
			//根据keys, 写入数据行
	        style = getDataStyle(workbook);
	        int k = 1;
	        for(int i=(batch-1)*10000;i<batch*10000;i++){
	        	row = sheet.createRow(k);
	        	row.setHeight((short) 300);
	        	
	        	if(i<data.size()){
		        	cell = row.createCell(0);
		            cell.setCellStyle(style);
		            text = new HSSFRichTextString(String.valueOf(k));
		            cell.setCellValue(text);
	        	
	        		Map<String, Object> rowData = data.get(i);
		        	for(int j=1;j<keys.length+1;j++){
		        		cell = row.createCell(j);
		        		cell.setCellStyle(style);
		        		Object obj = rowData.get(keys[j-1]);
		        		
						// 判断值的类型后进行强制类型转换
		        		HSSFRichTextString textValue=null;
						if (obj instanceof Integer) {
							int intValue = (Integer) obj;
							textValue = new HSSFRichTextString(String.valueOf(intValue)==null?"":String.valueOf(intValue));
						} else if (obj instanceof Float) {
							float fValue = (Float) obj;
							textValue = new HSSFRichTextString(String.valueOf(fValue)==null?"":String.valueOf(fValue));
						} else if (obj instanceof Double) {
							double dValue = (Double) obj;
							textValue = new HSSFRichTextString(String.valueOf(dValue)==null?"":String.valueOf(dValue));
						} else if (obj instanceof Long) {
							long longValue = (Long) obj;
							textValue = new HSSFRichTextString(String.valueOf(longValue)==null?"":String.valueOf(longValue));
						}else if (obj instanceof Date) {
		                    Date date = (Date) obj;
		                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		                    textValue = new HSSFRichTextString(sdf.format(date)==null?"":sdf.format(date));
		                }else{
		                	textValue = new HSSFRichTextString(String.valueOf(obj)==null?"":String.valueOf(obj));
		                }
						cell.setCellValue(textValue);
					}
	        	}
	        	k++;
	        }
        }
		return workbook;
	}
	
	private HSSFCellStyle getHeaderStyle(HSSFWorkbook workbook) {
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.RED.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short)10.5);
		font.setColor(HSSFColor.WHITE.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);

		return style;
	}
	
	private HSSFCellStyle getDataStyle(HSSFWorkbook workbook) {
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style.setFont(font);

		return style;
	}
}
