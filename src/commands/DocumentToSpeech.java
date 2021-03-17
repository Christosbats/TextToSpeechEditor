package commands;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Document;

public class DocumentToSpeech implements ActionListener {
	private Document document;
	private int type;

	

	public DocumentToSpeech(Document document,int type) {

		this.document = document;
		this.type = type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(type==1){
			document.playContents();
		}
		else if(type==2){
			document.playReverseContents();
		}
		else if(type==3){
			document.playEncodedContents();
		}
	}
}
