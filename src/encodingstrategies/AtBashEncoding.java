package encodingstrategies;

import java.util.HashMap;

public class AtBashEncoding extends TemplateEncoding implements EncodingStrategy {

	private HashMap<Character, Character> map;

	//I create a map for every letter to encoded letter
	public AtBashEncoding() {
		map = new HashMap<Character, Character>();
		for (int u = (int) 'A'; u <= (int) 'Z'; u++) {
			map.put((char) (u), (char) ('A' + ('Z' - u)));
		}
		for (int l = (int) 'a'; l <= (int) 'z'; l++) {
			map.put((char) (l), (char) ('a' + ('z' - l)));
		}
	}

	@Override
	public char mapCharacter(char key) {

		return map.get(key);
	}

}
