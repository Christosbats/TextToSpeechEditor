package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import model.Document;

public class SaveDocument implements ActionListener {

	private JFrame frame;
	private Document document;

	private File file;
	private JFileChooser fileChooser = new JFileChooser();

	public SaveDocument(JFrame frame, Document doc) {
		this.frame = frame;
		this.document = doc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String path = document.getPath();
		if (path == null) {
			int returnVal = fileChooser.showSaveDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				writeToFile(file, document);
			} else {
				System.out.println("Open command cancelled by user." + "\n");
			}
		} else {
			file = new File(document.getPath());
			writeToFile(file, document);
		}
	}

	private void writeToFile(File file, Document document) {
		System.out.println("Saving: " + file.getName() + "\n");
		document.setDate(new Date());
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

			document.writeToFile(bw);

			bw.close();

		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}
	
	public File getFile() {
		return this.file;
	}

}
