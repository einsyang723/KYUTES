package main;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class tryReader extends CSVReader {
	static String nameDpm = "";
	static String line;
	static String filePath = "";
	static JFileChooser fileChooser;

	public tryReader(String pathname) throws FileNotFoundException {
		super(pathname);
	}

	public static void readFile(String defaultPath) throws Exception {
		fileChooser = new JFileChooser(defaultPath);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setFileFilter(new FileNameExtensionFilter("csv(*.csv)", "csv"));
		int returnVal = fileChooser.showOpenDialog(fileChooser);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().getAbsolutePath();
		}
	}
}