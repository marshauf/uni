package com.marcelhauf.oose.aufgabe11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Copy {
	public static void convert(String inFile, String outFile, String inEnc, String outEnc) throws Exception {
		File in = new File(inFile);
		File out = new File(outFile);
		
		if(inEnc.equals(outEnc)) {
			out.createNewFile();
		}
		
		FileInputStream reader = new FileInputStream(in);
		FileOutputStream writer = new FileOutputStream(out);
		
		byte[] dataIn = new byte[(int)in.length()];
		reader.read(dataIn);
		reader.close();
		
		if(inEnc.equals(outEnc)) {
			writer.write(dataIn);
			writer.close();
			return;
		}
		
		String str = new String(dataIn, inEnc);
		byte[] dataOut = str.getBytes(outEnc);
		writer.write(dataOut);
		writer.close();
	}
	
	public static void main(String[] args) {
		if (args.length == 4) {
			try {
				convert(args[0], args[1], args[2], args[3]);
			} catch (Exception e) {
				System.out.println(e);
			}
			return;
		} else if (args.length == 2) { // Simple copy
			try {
				convert(args[0], args[1], "", "");
			} catch (Exception e) {
				System.out.println(e);
			}
			return;
		}
		System.out.println("Usage: java aufgabe11 (inFile outFile [inEnc outEnc]) ");
	}
}
