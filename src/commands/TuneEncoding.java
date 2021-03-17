package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;

public class TuneEncoding implements ActionListener {
	private String type;
	private Document document;

	public TuneEncoding(String type, Document document) {
		this.type = type;
		this.document = document;


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		document.tuneEncodingStrategy(type);
	}

}
