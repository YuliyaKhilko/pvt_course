package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Sentence implements Replacer {

	private ArrayList<Word> words ;
	public Sentence(String sentence) {
		String[] array = sentence.split(" ");
		 words = Arrays.asList(array).stream().map(str -> new Word(str))
				.collect(Collectors.toCollection(ArrayList::new));

	}
	@Override
	public String replace(int position, char replacement) {
		return words.stream().map(part -> part.replace(position, replacement)).collect(Collectors.joining(" "));

	}

}
