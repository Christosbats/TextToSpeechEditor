package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;

import commands.CommandsFactory;
import commands.EditDocument;

import model.Document;

public class Text2SpeechEditorView {

	private static Text2SpeechEditorView Text2SpeechEditorViewInstance = null;

	private JFrame frame;

	private CommandsFactory commandFactory = new CommandsFactory();

	private boolean isEncoded;
	private boolean isReversed;

	private Document currentDocument;

	/**
	 * @wbp.parser.entryPoint
	 */
	public Text2SpeechEditorView() {
		
		currentDocument = new Document();

		frame = new JFrame();
		frame.setBounds(100, 100, 590, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createWidgets();
		
		frame.setVisible(true);

	}

	private void createWidgets() {

		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		JScrollPane scrollPane = new JScrollPane();
		

		JTextArea textArea = new JTextArea();
		JTextArea numArea = new JTextArea();
		textArea.setVisible(false);		
		scrollPane.setViewportView(textArea);
		scrollPane.setRowHeaderView(numArea);
		frame.getContentPane().add(scrollPane);
		
		textArea.getDocument().addDocumentListener(new EditDocument(numArea,textArea,currentDocument));

		//Menu Bar
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// File Menu
		JMenu mnMenuOptions = new JMenu("File");
		menuBar.add(mnMenuOptions);

		JMenuItem MenuItemNewDoc = new JMenuItem("New Document");
		mnMenuOptions.add(MenuItemNewDoc);

		JMenuItem MenuItemOpenDoc = new JMenuItem("Open Document");
		mnMenuOptions.add(MenuItemOpenDoc);

		JMenuItem MenuItemSaveDoc = new JMenuItem("Save Document");
		mnMenuOptions.add(MenuItemSaveDoc);

		// Text to Speech Menu
		JMenu ListeningOptions = new JMenu("Listening");
		menuBar.add(ListeningOptions);

		// Full text choices
		JMenu MenuFullText = new JMenu("Full Text");
		ListeningOptions.add(MenuFullText);

		JMenuItem MenuItemPlayText = new JMenuItem("Play all text");
		MenuFullText.add(MenuItemPlayText);

		JMenuItem MenuItemPlayTextReversed = new JMenuItem("Play all text in reverse");
		MenuFullText.add(MenuItemPlayTextReversed);

		JMenuItem MenuItemPlayTextEncoded = new JMenuItem("Play all  text encoded");
		MenuFullText.add(MenuItemPlayTextEncoded);

		// Line choices
		JMenu MenuLine = new JMenu("A specific Line");
		ListeningOptions.add(MenuLine);

		JMenuItem MenuItemSpecificLine = new JMenuItem("Play a specific Line");
		MenuLine.add(MenuItemSpecificLine);

		JMenuItem MenuItemPlayLineReversed = new JMenuItem("Play a specific Line in reverse");
		//MenuItemPlayLineReversed.setVisible(isReversed);
		MenuLine.add(MenuItemPlayLineReversed);

		JMenuItem MenuItemPlayLineEncoded = new JMenuItem("Play a specific Line encoded");
		MenuLine.add(MenuItemPlayLineEncoded);
		
		// Settings Menu
		JMenu mnMenuSettings = new JMenu("Settings");
		menuBar.add(mnMenuSettings);

		// Encoding Menu
		JMenu mnMenuEncode = new JMenu("Tune Encode");
		mnMenuSettings.add(mnMenuEncode);

		JMenuItem MenuItemRot13 = new JMenuItem("Set Rot13 Encoding");
		mnMenuEncode.add(MenuItemRot13);

		JMenuItem MenuItemAtBash = new JMenuItem("Set AtBash Encoding");
		mnMenuEncode.add(MenuItemAtBash);

		// Tune Audio Menu Pop-up window
		JMenuItem MenuItemTuneAudio = new JMenuItem("Tune Audio");
		mnMenuSettings.add(MenuItemTuneAudio);

		// Adding commands to widgets
		
		MenuItemNewDoc.addActionListener(commandFactory.createCommand("newDoc", frame, textArea, currentDocument));
		MenuItemOpenDoc.addActionListener(commandFactory.createCommand("openDoc", frame, textArea, currentDocument));
		MenuItemSaveDoc.addActionListener(commandFactory.createCommand("saveDoc", frame, textArea, currentDocument));
		MenuItemPlayText.addActionListener(commandFactory.createCommand("docToSpeech", frame, textArea, currentDocument));
		MenuItemPlayTextReversed.addActionListener(commandFactory.createCommand("docToSpeechReversed", frame, textArea, currentDocument));
		MenuItemPlayTextEncoded.addActionListener(commandFactory.createCommand("docToSpeechEncoded", frame, textArea, currentDocument));
		MenuItemSpecificLine.addActionListener(commandFactory.createCommand("lineToSpeech", frame, textArea, currentDocument));
		MenuItemPlayLineReversed.addActionListener(commandFactory.createCommand("lineToSpeechReversed", frame, textArea, currentDocument));
		MenuItemPlayLineEncoded.addActionListener(commandFactory.createCommand("lineToSpeechEncoded", frame, textArea, currentDocument));
		MenuItemRot13.addActionListener(commandFactory.createCommand("tuneEncodingRot13",frame, textArea, currentDocument));
		MenuItemAtBash.addActionListener(commandFactory.createCommand("tuneEncodingAtBash",frame, textArea, currentDocument));
		MenuItemTuneAudio.addActionListener(commandFactory.createCommand("tuneAudio", frame, textArea, currentDocument));

		

	}

	public boolean isReversed() {
		return isReversed;
	}

	public boolean isEncoded() {
		return isEncoded;
	}


	public Document getCurrentDocument() {
		return this.currentDocument;
	}

	public static Text2SpeechEditorView getSingletonView() {
		if (Text2SpeechEditorViewInstance == null)
			Text2SpeechEditorViewInstance = new Text2SpeechEditorView();
		return Text2SpeechEditorViewInstance;

	}

	public static void main(String[] args) {
		getSingletonView();

	}
}
