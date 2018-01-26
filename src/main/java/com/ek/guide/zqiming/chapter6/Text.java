package com.ek.guide.zqiming.chapter6;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Text {
	
	 public static void main(String[] args) {
			
		 readFile();
		 test();
		}

	 public static void readFile(){
			 
			BufferedReader in = null;
			String temp = "";
			StringBuffer fileContent = new StringBuffer();
			try {
				in = new BufferedReader(new FileReader("C:\\visualmark1.vim"));
				if((temp=in.readLine()) != null){
					fileContent.append(temp);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				System.out.println(new String(fileContent.toString().getBytes(),"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	 }
	 
	 
	 
		private static void test() {
			String dir = "c:\\";
			String fileName = "visualmark1.vim";
 
			try {
				String encoding = codeString(dir,fileName);
				System.out.println("encoding:"+encoding);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		/**
	     * 判断文件的编码格式
	     * @param fileName :file
	     * @return 文件编码格式
	     * @throws Exception
	     */
	    @SuppressWarnings("resource")
		public static String codeString(String dir,String fileName) throws Exception{
	    	
	        File file = new File(dir+fileName);
	        if(file==null || !file.exists()){
	        	System.out.println("文件不存在..."+file.getAbsolutePath());
	        	return null;
	        }
	        
			BufferedInputStream bin = new BufferedInputStream( new FileInputStream(file));
	        int p = (bin.read() << 8) + bin.read();
	        String code = null;
	        //其中的 0xefbb、0xfffe、0xfeff、0x5c75这些都是这个文件的前面两个字节的16进制数
	        switch (p) {
	            case 0xefbb:
	                code = "UTF-8";
	                break;
	            case 0xfffe:
	                code = "Unicode";
	                break;
	            case 0xfeff:
	                code = "UTF-16BE";
	                break;
	            case 0x5c75:
	                code = "ANSI|ASCII" ;
	                break ;
	            default:
	                code = "GBK";
	        }
	         
	        return code;
	    }
}