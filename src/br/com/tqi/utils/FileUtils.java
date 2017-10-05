package br.com.tqi.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;	

/**
 * Controla a leitura e get values do arquivo de propriedades
 *
 */
public class FileUtils {

	private static Properties props;
	
	public FileUtils(String file) {
		props = new Properties();
		FileInputStream fis;

		try {
			fis = new FileInputStream(file);
			props.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getValue(String chave) {
		return props.getProperty(chave);
	}

}
