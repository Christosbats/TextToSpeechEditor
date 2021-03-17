package commands;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

import model.Document;

public class EditDocument implements DocumentListener {

	JTextArea numArea;
	JTextArea textArea;
	Document document;

	public EditDocument(JTextArea numArea,JTextArea textArea,Document document) {
		this.numArea = numArea;
		this.textArea = textArea;
		numArea.setBackground(Color.lightGray);
		numArea.setEditable(false);
		this.document = document;
		
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateLineNumbers();

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateLineNumbers();

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateLineNumbers();
	}

	public void updateLineNumbers()
    {
        String lineNumbersText = getLineNumbersText();
        numArea.setText(lineNumbersText);
        document.setContents(textArea.getText());
    }

    private String getLineNumbersText()
    {
        int caretPosition = textArea.getDocument().getLength();
        Element root = textArea.getDocument().getDefaultRootElement();
        StringBuilder lineNumbersTextBuilder = new StringBuilder();
        lineNumbersTextBuilder.append("0 ").append(System.lineSeparator());

        for (int elementIndex = 1; elementIndex < root.getElementIndex(caretPosition)+1; elementIndex++)
        {
            lineNumbersTextBuilder.append(elementIndex).append(System.lineSeparator());
        }

        return lineNumbersTextBuilder.toString();
    }

}
