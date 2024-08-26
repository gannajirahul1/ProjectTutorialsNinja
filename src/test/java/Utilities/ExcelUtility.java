package Utilities;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.FillPatternType;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtility {
		
		
		public  FileInputStream fi;
		public  FileOutputStream fo;
		public  XSSFWorkbook workbook;
		public  XSSFSheet ws;
		public  XSSFRow row;
		public  XSSFCell col;
		public  CellStyle style;
		 String path;
		
		public ExcelUtility(String path)
		{
			this.path=path;			
		}
			
		
		//1)Rowcount:it will returns the rowcount
		public int getRowCount(String sheetName) throws IOException
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			ws=workbook.getSheet(sheetName);
			int rowCount=ws.getLastRowNum();
			workbook.close();
			fi.close();
			return rowCount;
		}
		
		//2)CellCount:it will return the cellcount(Column count)
		public int getCellCount(String sheetName,int rownum) throws IOException
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			ws=workbook.getSheet(sheetName);
			row=ws.getRow(rownum);
			int CellCount=row.getLastCellNum();
			workbook.close();
			fi.close();
			return CellCount;
		}

		//3)getCellData:it will return the data which prsent in cell/column  or read the data
		public String getCellData(String sheetName,int rownum,int colnum) throws IOException
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			ws=workbook.getSheet(sheetName);
			row=ws.getRow(rownum);
			col=row.getCell(colnum);
			
			DataFormatter formatter=new DataFormatter();
			String data;
			try 
			{
			//data=toString();	
				
				data=formatter.formatCellValue(col);
			}
			catch (Exception e)
			{
				data="";
			}
			workbook.close();
			fi.close();
			return data;
		}
		
		//4)setCellData:it is used to write the data into cell
		public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
		{
			File xlfile=new File(path);
			if(!xlfile.exists())				//if file not exists then create new file
			{	
				workbook=new XSSFWorkbook();
				fo=new FileOutputStream(path);
				workbook.write(fo);
			}
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			if(workbook.getSheetIndex(sheetName)==-1)//if sheet not exists create new sheet
				workbook.createSheet(sheetName);
			ws=workbook.getSheet(sheetName);
		//	if(workbook.getRow(rownum)==null)//if row not exists create a row
			//	ws.createRow(rownum);
			//row=ws.getRow(rownum);
			
			col=row.createCell(colnum);
			col.setCellValue(data);
			fo=new FileOutputStream(path);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		}
		
		//5)fillgreenColor:it will fill the cells with green color
		public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			ws=workbook.getSheet(sheetName);
			row=ws.getRow(rownum);
			col=row.getCell(colnum);
			style=workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			col.setCellStyle(style);
			fo=new FileOutputStream(path);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		}
		//6)fillRedColor:it will fill the cell with red color
		public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			ws=workbook.getSheet(sheetName);
			row=ws.getRow(rownum);
			col=row.getCell(colnum);
			style=workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			col.setCellStyle(style);
			fo=new FileOutputStream(path);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
			
		}

	}
		

