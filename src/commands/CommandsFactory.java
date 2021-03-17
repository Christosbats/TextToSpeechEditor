package commands;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.Document;

public class CommandsFactory {

	public ActionListener createCommand(String type, JFrame frame, JTextArea textArea, Document document) {
		if (type.equals("docToSpeech")) {
			return new DocumentToSpeech(document,1);
		}
		if (type.equals("docToSpeechReversed")) {
			return new DocumentToSpeech(document,2);
		}
		if (type.equals("docToSpeechEncoded")) {
			return new DocumentToSpeech(document,3);
		}
		if (type.equals("newDoc")) {
			return new NewDocument(textArea, document);
		}
		if (type.equals("lineToSpeech")) {
			return new LineToSpeech(document,1);
		}
		if (type.equals("lineToSpeechReversed")) {
			return new LineToSpeech(document,2);
		}
		if (type.equals("lineToSpeechEncoded")) {
			return new LineToSpeech(document,3);
		}
		if (type.equals("openDoc")) {
			return new OpenDocument(frame, textArea, document);
		}
		if (type.equals("saveDoc")) {
			return new SaveDocument(frame,document);
		}
		if (type.equals("tuneAudio")) {
			return new TuneAudio(document);
		}
		if (type.equals("tuneEncodingRot13")) {
			return new TuneEncoding("tuneEncodingRot13",document);
		}
		if (type.equals("tuneEncodingAtBash")) {
			return new TuneEncoding("tuneEncodingAtBash",document);
		}

		System.out.println("If the code got up to here, you passed a wrong argument to the Command Factory");
		return null;

	}

}
