package com.marcelhauf.oose.aufgabe11;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dir {
	public static List<File> getFileList() {
		String wd = System.getProperty("user.dir");
		return getFileList(wd);
	}
	
	public static List<File> getFileList(String fileName) {
		return getFileList(new File(fileName));
	}
	
	public static List<File> getFileList(File startFile) {
		List<File> result = new ArrayList<File>();
		return getFileList(startFile, result);
	}
	
	public static List<File> getFileList(File startFile, List<File> result) {
		result.add(startFile);
		if (startFile.isDirectory()) {
			for(File subFile : startFile.listFiles()) {
				getFileList(subFile, result);
			}
		}
		
		
		
		return result;
	}
	
	public static void main(String[] args) {
		List<File> tree = getFileList();
		for(File file : tree) {
			System.out.println(file.getPath());
		}
	}
}
