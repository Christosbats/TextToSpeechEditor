package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.Document;

public class OpenDocument implements ActionListener {

	private JFrame frame;
	private JTextArea textArea;
	private Document document;

	private JFileChooser fileChooser = new JFileChooser();

	public OpenDocument(JFrame frame, JTextArea textArea, Document document) {
		this.frame = frame;
		this.document = document;
		this.textArea = textArea;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int returnVal = fileChooser.showOpenDialog(frame);

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			File file = fileChooser.getSelectedFile();
			textArea.setVisible(true);
			document.setPath(file.getPath());
			System.out.println("Opening: " + file.getName()  + "\n");
			document.setTitle(file.getName());
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {

				String currentLine;
				String fileBuffer = "";
				while ((currentLine = br.readLine()) != null) {
					fileBuffer += currentLine + "\n";
				}
				
				
				document.setContents(fileBuffer);
				textArea.setText(fileBuffer);
				
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("Open command cancelled by user." + "\n");
		}

	}

}
