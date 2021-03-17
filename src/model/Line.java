package model;

import java.util.ArrayList;

import encodingstrategies.EncodingStrategy;
import encodingstrategies.StrategiesFactory;
import text2speechapis.TextToSpeechAPI;
import text2speechapis.TextToSpeechAPIFactory;

public class Line {

	private ArrayList<String> words; // = new ArrayList<String>();
	private StrategiesFactory strategy;
	private EncodingStrategy encodingStrategy;
	private TextToSpeechAPI audioManager;
	private TextToSpeechAPIFactory apiFactory ;
	
	public Line() {
		apiFactory = new TextToSpeechAPIFactory();
		audioManager = apiFactory.createTTSAPI("adapter");
		this.words = new ArrayList<String>();

	}

	public void playLine() {
		audioManager.play(this.toString());
	}

	public void playReverseLine() {
		// Play every word in the line reversed
		String s = "";
		for (int w = words.size() -1; w >= 0; w--) {
			s += words.get(w) +" ";
		}
		audioManager.play(s);

	}

	public void playEncodedLine() {
		ArrayList<String> encodedWords = new ArrayList<String>();
		// encode every word
		for (String word : words) {
			encodedWords.add(encodingStrategy.encode(word));
		}
		// play every encoded words
		String line ="";
		for (String word : encodedWords) {
			line += word +" ";
		}
		audioManager.play(line);
	}



	public String toString() {
		String line = "";
		for (String word : words) {
			line += word + " ";
		}
		return line;
	}




	public void setWords(String line) {
		String[] splitedLine = line.split(" ");
		for (String w: splitedLine) {
			if(!w.isEmpty())
				words.add(w);
		}
	}
	
	

	public ArrayList<String> getWords() {
		return words;
	}

	public void tuneAudioManager(TextToSpeechAPI audioManager) {
		this.audioManager = audioManager;
	}
	
	public void tuneEncodingStrategy(String encStrategy) {
		strategy = new StrategiesFactory();
		this.encodingStrategy = strategy.createStrategy(encStrategy);
	}
	
	public void tuneLineAudio(int volume, int rate, int pitch) {
		audioManager.setVolume(volume);
		audioManager.setRate(rate);
		audioManager.setPitch(pitch);
	}
	
	//For test propose 
	public EncodingStrategy getEncoding() {
		return encodingStrategy;
	}
	
	public TextToSpeechAPI getAudioManager() {
		return audioManager;}


}
