package main;

import java.io.*;

/**
 * 使用例子: CSVReader reader = new CSVReader("D:\\114.csv"); String str1 =
 * reader.readLine();//得到第一行 String str2 = reader.readLine();//得到第二行
 */
public class CSVReader {

	static BufferedReader reader;

	public String readLine() throws IOException {
		return reader.readLine();
	}

	public CSVReader(String pathname) throws FileNotFoundException {
		CSVReader.reader = new BufferedReader(new FileReader(new File(pathname)));
	}

}
