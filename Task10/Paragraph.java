package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Paragraph implements Replacer {

	private ArrayList<Sentence> sentences;

	public Paragraph(String paragraph) {
		String[] array = paragraph.split("\\. ");
		sentences = Arrays.asList(array).stream().map(str -> new Sentence(str))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public String replace(int position, char replacement) {
		return sentences.stream().map(sentence -> sentence.replace(position, replacement)).collect(Collectors.joining(". "));
	}

}
