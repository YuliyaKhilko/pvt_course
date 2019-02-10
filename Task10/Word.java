package core;

public class Word implements Replacer {

	private String word;
	
	public Word(String word) {
		this.word = word;
	}
	@Override
	public String replace(int position, char replacement) {
		char[] chars = word.toCharArray();
		for (int i = position - 1; i < chars.length; i += position) {
			chars[i] = replacement;
		}
		return String.valueOf(chars);
	}

}
