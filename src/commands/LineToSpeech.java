package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Document;

public class LineToSpeech implements ActionListener {
	private String nline;
	private Document document;
	private int type;

	public LineToSpeech(Document document, int type) {
		this.document = document;
		this.type = type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int lineNumber;
		if ((lineNumber = getLineNumber()) >= 0) {
			if (type == 1) {
				document.playLine(lineNumber);
			} else if (type == 2) {
				document.playReverseLine(lineNumber);
			} else if (type == 3) {
				document.playEncodedLine(lineNumber);
			}
		}

	}

	//Method appear dialog box for line number
	private int getLineNumber() {
		JTextField Line = new JTextField(15);
		JPanel linePanel = new JPanel();
		linePanel.add(new JLabel("Number of line:"));
		linePanel.add(Line);

		int result = JOptionPane.showConfirmDialog(null, linePanel,
				"Please enter the number of the line you want to listen", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			nline = Line.getText();
			if (nline.isEmpty() == false) {
				return Integer.parseInt(nline);

			} else {
				JPanel linePanel2 = new JPanel();
				linePanel2.add(new JLabel("You should give a number"));
				JOptionPane.showConfirmDialog(null, linePanel2,
						"Error", JOptionPane.CLOSED_OPTION);
				

			}
		} else {
			nline = "";
		}
		return -1;
	}

}
