package commands;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Document;

//US-1
public class NewDocument implements ActionListener {

	
	private JTextArea textArea;
	private Document document;
	

	public NewDocument(JTextArea textArea, Document doc) {
		this.textArea = textArea;
		this.document = doc;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String titleAuthor[]= popUpDialog();
		document.setTitle(titleAuthor[0]);
		document.setAuthor(titleAuthor[1]);
		document.setDate(new Date());
		
		
	}
	

	
	private String[] popUpDialog() {
		String title;
		String author;

		JTextField titleField = new JTextField(25);
		JTextField authorField = new JTextField(25);

		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Title:"));
		myPanel.add(titleField);
		myPanel.add(Box.createHorizontalStrut(15)); 
		myPanel.add(new JLabel("Athors' Name:"));
		myPanel.add(authorField);
		
		int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Document's title and Athors' Name",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			 
			textArea.setText(null);
			title = titleField.getText();
			author = authorField.getText();
			textArea.setVisible(true);

			System.out.println("Ttitle: " + title);
			System.out.println("Author: " + author);
			
			return new String[] {title,author};
			
		}
		return null;
	}

}
