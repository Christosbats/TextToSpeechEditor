package encodingstrategies;

public class StrategiesFactory {

	public EncodingStrategy createStrategy(String strategy) {

		// TO-DO to write returns types for now only null
		switch (strategy) {
		case "tuneEncodingRot13":
			return new Rot13Encoding();
		case "tuneEncodingAtBash":
			return new AtBashEncoding();
		default:
			System.out.println("If the code got up to here, you passed a wrong argument to the Strategy Factory");
			return null;
		}

	}
}
