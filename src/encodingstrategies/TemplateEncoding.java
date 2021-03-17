package encodingstrategies;

public abstract class TemplateEncoding implements EncodingStrategy {

	@Override
	public String encode(String s) {
		String encoded = "";
        for(char c : s.toCharArray())
        {
            if(Character.isLetter(c))
            {
                encoded += mapCharacter(c);
            }
            else
            {
                encoded += c;
            }
        }
		return encoded;
	}
	
	public abstract char mapCharacter(char character);

}
