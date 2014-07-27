package com.home.fileOperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class FileOperaions {

	public static void main(String[] args) {
		 //justCreateNewFile();
		// constructFilePath();
		// readFileByBufferedInputStream();
		// writeFileByFileOutPutStream();
		// writeFileByBufferedWriter();
		//appendToFileByFileWritter();
		//deleteFileExample();
		//renameFile();
		copyFile();
	}

	/**
	 * It will just create a new file. If file already exist then it will not
	 * create new one
	 * 
	 */
	private static void justCreateNewFile() {
		try {
			File file = new File(getFilePath());
			if (file.createNewFile()) {
				System.out.println("File created successfully.");
			} else {
				System.out.println("File already exist");
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

	}

	private static void constructFilePath() {
		try {

			// If you want to create file in target
			String javaClassPath = System.getProperty("java.class.path");
			System.out.println(javaClassPath);
			String tempClass = StringUtils.substringBefore(javaClassPath,
					System.getProperty("path.separator"));
			System.out.println(tempClass);

			// User System.getProperty("user.dir");
			// to create file in Project Structure

			String filename = "testing.txt";
			String finalfile = "";
			String workingDir = tempClass;// System.getProperty("user.dir");
			finalfile = workingDir + File.separator + filename;
			System.out.println("Final filepath : " + finalfile);

			File file = new File(finalfile);
			if (file.createNewFile()) {
				System.out.println("Done");
			} else {
				System.out.println("File already exists!");
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	private static void readFileByBufferedInputStream() {
		BufferedReader br = null;
		try {
			String finalfile = getFilePath();
			File file = new File(finalfile);
			file.createNewFile();

			String sCurrentLine;
			br = new BufferedReader(new FileReader(finalfile));
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void writeFileByFileOutPutStream() {
		FileOutputStream fop = null;
		File file;
		String content = "This is the text content";

		try {

			file = new File(getFilePath());
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void writeFileByBufferedWriter() {
		try {

			String content = "This is the content to write into file by buffered writer";

			File file = new File(getFilePath());

			// if file does'nt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void appendToFileByFileWritter(){
		
		/*FileWritter, a character stream to write characters to file. 
		 * By default, it will replace all the existing content with 
		 * new content, however, when you specified a true (boolean) 
		 * value as the second argument in FileWritter constructor, 
		 * it will keep the existing content and append the 
		 * new content in the end of the file.*/
		try{
    		String data = " This content will append to the end of the file";
 
    		File file =new File(getFilePath());
 
    		//if file does'nt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
 
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(data);
    	        bufferWritter.close();
 
	        System.out.println("Done");
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}

	private static void deleteFileExample(){
		try{
			 
    		File file = new File(getFilePath());
 
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
 
    	}catch(Exception e){
 
    		e.printStackTrace();
 
    	}
	}
	private static void renameFile(){
		File oldfile =new File(getFilePath());
		File newfile =new File("newfile.txt");
		
		if(oldfile.renameTo(newfile)){
			System.out.println("Rename succesful");
		}else{
			System.out.println("Rename failed");
		}
 
	}
	private static void copyFile(){
		try{
			File oldFile = new File(getFilePath());
			File destFile = new File ("copiedFile");
			
			Collections.emptyList();
			FileUtils.copyFile(oldFile, destFile);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static String getFilePath() {

		String filename = "newfile.txt";
		String finalfile = "";
		String workingDir = System.getProperty("user.dir");
		finalfile = workingDir + File.separator + filename;
		System.out.println("Final filepath : " + finalfile);
		return finalfile;
	}
}
