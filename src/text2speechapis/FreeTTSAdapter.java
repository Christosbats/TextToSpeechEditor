package text2speechapis;


import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTSAdapter implements TextToSpeechAPI {

	private VoiceManager vm;
	private Voice voice;

	public FreeTTSAdapter() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		this.vm = VoiceManager.getInstance();
		this.voice = vm.getVoice("kevin16");
		if (voice != null) {
			this.voice.allocate();// Allocating Voice
		} else {
			throw new IllegalStateException("Cannot find voice: kevin16");
		}
		
	}

	@Override
	public void play(String line) {
		this.voice.speak(line);

	}

	@Override
	public void setVolume(int volume) {
		this.voice.setVolume((float)volume);
		

	}
	
	@Override
	public void setRate(int rate) {
		this.voice.setRate(rate);
		

	}

	@Override
	public void setPitch(int pitch) {
		this.voice.setPitch((float)pitch/100);
		

	}
	public float getVolume(){
		return this.voice.getVolume();
	}

	

}
