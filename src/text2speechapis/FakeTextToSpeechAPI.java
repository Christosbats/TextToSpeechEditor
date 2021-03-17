package text2speechapis;

public class FakeTextToSpeechAPI implements TextToSpeechAPI {

	@Override
	public void play(String line) {
		System.out.println(line);

	}

	@Override
	public void setVolume(int volume) {
		System.out.print(volume);

	}

	@Override
	public void setPitch(int pitch) {
		System.out.print(pitch);

	}

	@Override
	public void setRate(int rate) {
		System.out.print(rate);

	}

}
