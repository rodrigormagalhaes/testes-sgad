package br.com.tqi.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOManager {

	InputStream is;
	InputStreamReader isr;
	BufferedReader br;

	public IOManager(String inputFile) throws FileNotFoundException{

		is = new FileInputStream(inputFile);
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);

	}
	
	public String getLineInput() throws IOException{
		return br.readLine();
	}	
	
	public void close() throws IOException{
		br.close();

	}
	
}

