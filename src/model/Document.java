package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import text2speechapis.TextToSpeechAPI;

public class Document {
	private String NEW_LINE = "\n";
	private ArrayList<Line> contents;

	private String title;
	private String author;
	private Date date;
	private String path = null;


	public Document() {
		
		contents = new ArrayList<Line>();

	}
	public Document(String title, String author, Date date) {
		
		contents = new ArrayList<Line>();
		this.title = title;
		this.author = author;
		this.date = date;

	}

	public void playContents() {
		for (int i = 0; i < contents.size(); i++)
			playLine(i);

	}

	public void playReverseContents() {
		for (int i = contents.size() - 1; i >= 0; i--) {
			playReverseLine(i);
		}
	}

	public void playEncodedContents() {
		for (int i = 0; i < contents.size(); i++)
			playEncodedLine(i);
	}

	public void playLine(int i) {
		contents.get(i).playLine();
	}

	public void playReverseLine(int i) {
		contents.get(i).playReverseLine();
	}

	public void playEncodedLine(int i) {
		contents.get(i).playEncodedLine();

	}

	public void setContents(String input) {
		contents = new ArrayList<Line>();
		String[] splitk = input.split(NEW_LINE);
		Line line;

		for (int i = 0; i < splitk.length; i++) {
			line = new Line();
			line.setWords(splitk[i]);
			contents.add(line);
		}
	}

	public void writeToFile(BufferedWriter bw) throws IOException {
		for (Line l : contents) {
			bw.write(l.toString());
			bw.newLine();
		}
	}

	public void tuneEncodingStrategy(String encStrategy) {
		for (Line l : contents)
			l.tuneEncodingStrategy(encStrategy);
	}

	public void tuneDocumentAudio(int volume, int rate, int pitch) {

		for (Line l : contents)
			l.tuneLineAudio(volume, rate, pitch);
	}

	// For Test Proposes
	public void tuneAudioManager(TextToSpeechAPI audioManager) {
		for (Line l : contents)
			l.tuneAudioManager(audioManager);
	}

	public ArrayList<Line> getContents() {
		return contents;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPath(String path) {
		this.path = path;
		// System.out.println(path);
	}

	public String getPath() {
		return this.path;
	}

	public String getAuthor() {
		return author;
	}

	public Date getDate() {
		return date;
	}

}
