package text2speechapis;

public class TextToSpeechAPIFactory {

	public  TextToSpeechAPI createTTSAPI(String api) {
		
		switch(api) {
			case "adapter":
				return new FreeTTSAdapter();
			case "fake":
				return new FakeTextToSpeechAPI();
			default:
				System.out.println("If the code got up to here, you passed a wrong argument to the API Factory");
				return null;
		}
		
	}
}
