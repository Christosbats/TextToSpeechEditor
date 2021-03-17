package text2speechapis;

public interface TextToSpeechAPI {
	
	public void play(String line);

	public void setVolume(int volume);
	
	public void setPitch(int pich);
	
	public void setRate(int rate);
}
