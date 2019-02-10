package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Text implements Replacer {
	private ArrayList<Paragraph> paragraphs;

	public Text(String text) {
		String[] array = text.split("\\n");
		paragraphs = Arrays.asList(array).stream().map(str -> new Paragraph(str))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public String replace(int position, char replacement) {
		return paragraphs.stream().map(paragraph -> paragraph.replace(position, replacement)).collect(Collectors.joining("\\n"));
	}

	public static void main(String[] args) {
		String inputText = "";
		Scanner scanner = new Scanner(System.in);
		String line;
		System.out.println("Type text: ");
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.isEmpty()) {
				break;
			}
			inputText += line + "\n";
		}
		System.out.println("\n" + inputText);
		System.out.println("n : ");
		int n = scanner.nextInt();
		scanner.close();
		System.out.println (new Text(inputText).replace(n, '%'));
		
	}

	
}
