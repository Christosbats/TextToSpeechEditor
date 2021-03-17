package encodingstrategies;

import java.util.HashMap;

public class Rot13Encoding extends TemplateEncoding implements EncodingStrategy {

	private HashMap<Character, Character> map;

	//I create a map for every letter to encoded letter
	public Rot13Encoding() {
		map = new HashMap<Character, Character>();
		for (int u = (int) 'A'; u <= (int) 'Z'; u++) {
			if (u <= (int) 'M')
				map.put((char) (u), (char) (u + 13));
			else
				map.put((char) (u), (char) (u - 13));
		}
		for (int l = (int) 'a'; l <= (int) 'z'; l++) {
			if (l <= (int) 'm')
				map.put((char) (l), (char) (l + 13));
			else
				map.put((char) (l), (char) (l - 13));
		}
	}

	@Override
	public char mapCharacter(char key) {
		return map.get(key);
	}

}
