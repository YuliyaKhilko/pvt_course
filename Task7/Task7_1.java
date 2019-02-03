package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task7_1 {

	public static void main(String[] args) {
		String[] array = fillArrayWithStringValues();
		inAscOrder(array);
		findLongestString(array);
		inDescOrder(array);
		lengthLessThanAverage(array);
		countDistinctCharacter(array);
		vowelConsonantCheck(array);
		compareCodes(array);
		onlyDistinctSymbols(array);
		findPalindrome(array);

	}

	// Fills array with string values entered from console.
	// Array length is also read from console
	public static String[] fillArrayWithStringValues() {
		int numberOfStrings;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of strings");

		numberOfStrings = Integer.parseInt(scanner.nextLine());
		/*
		 * had to use Integer.parseInt instead of nextInt() as nextInt() leaves in
		 * scanner buffer /n and nextLine() reads it as next entered string
		 */
		System.out.println("Please type Strings. Each new string enter as new line.");
		String[] array = new String[numberOfStrings];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextLine();
		}
		scanner.close();
		return array;
	}

	// 1. Ввести n строк с консоли, найти самую короткую и самую длинную строки.
	// Вывести найденные строки и их длину.
	public static void findLongestString(String[] array) {
		// create the list where elements = length of String values in array
		List<String> list = Arrays.asList(array).stream().sorted((s1, s2) -> Long.compare(s1.length(), s2.length()))
				.collect(Collectors.toList());
		printLongestShortestStrings(list.get(0), list.get(list.size() - 1));
		
	}
	
	public static void printLongestShortestStrings(String max, String min) {
		final String LONGEST_STRING = "Longest string: %s, its length: %s";
		final String SHORTEST_STRING = "Shortest string: %s, its length: %s";
		System.out.println(String.format(LONGEST_STRING, max, max.length()));
		System.out.println(String.format(SHORTEST_STRING, min, min.length()));
	}

	// 2. Упорядочить и вывести строки в порядке возрастания (убывания) значений их
	// длины.
	public static void inAscOrder(String[] array) {

		String[] array2 = array.clone();
		for (int i = 0; i < array2.length; i++) {
			String currentString = array2[i];
			int currentStringLength = array2[i].length();
			int indexPrevious = i - 1;
			while (indexPrevious >= 0 && currentStringLength < array2[indexPrevious].length()) {
				array2[indexPrevious + 1] = array2[indexPrevious];
				array2[indexPrevious] = currentString;
				indexPrevious--;
			}
		}
		System.out.println(Arrays.asList(array2));
	}

	public static void inDescOrder(String[] array) {

		String[] array2 = array.clone();
		for (int i = 0; i < array2.length; i++) {
			String currentString = array2[i];
			int currentStringLength = array2[i].length();
			int indexPrevious = i - 1;
			while (indexPrevious >= 0 && currentStringLength > array2[indexPrevious].length()) {
				array2[indexPrevious + 1] = array2[indexPrevious];
				array2[indexPrevious] = currentString;
				indexPrevious--;
			}
		}
		System.out.println(Arrays.asList(array2));
	}

	// 3. Вывести на консоль те строки, длина которых меньше (больше) средней, а
	// также длину.

	public static void lengthLessThanAverage(String[] array) {
		final String MESSAGE = "String: %s. The length = %s";
		int sumOfElementslength = 0;
		for (int i = 0; i < array.length; i++) {
			sumOfElementslength += array[i].length();
		}
		float averageLength = sumOfElementslength / array.length;
		List<String> lessThanAverage = new ArrayList<String>();
		List<String> biggerThanAverage = new ArrayList<String>();

		for (int i = 0; i < array.length; i++) {
			if (array[i].length() < averageLength) {
				lessThanAverage.add(array[i]);
			} else if (array[i].length() > averageLength) {
				biggerThanAverage.add(array[i]);
			}
		}
		System.out.println("Less than average: ");
		lessThanAverage.stream()
				.forEach(element -> System.out.println(String.format(MESSAGE, element, element.length())));
		System.out.println("Bigger than average: ");
		biggerThanAverage.stream()
				.forEach(element -> System.out.println(String.format(MESSAGE, element, element.length())));
	}

	// 4. Найти слово, в котором число различных символов минимально. Если таких
	// слов несколько, найти первое из них.

	public static void countDistinctCharacter(String[] array) {
		String minDistinctChars = Arrays.asList(array).stream()
				.sorted((s1, s2) -> Long.compare(s1.chars().distinct().count(), s2.chars().distinct().count()))
				.findFirst().get();

		System.out.println("String with min distinct count characters " + minDistinctChars);
	}

	// 5. Ввести n слов с консоли. Найти количество слов, содержащих только символы
	// латинского алфавита, а среди них – количество слов с равным числом гласных и
	// согласных букв.
	public static void vowelConsonantCheck(String[] array) {
		Stream<String> filteredStream1 = Arrays.asList(array).stream().filter(str -> str.matches("^[A-Za-z]+$"));
		Stream<String> filteredStream2 = Arrays.asList(array).stream().filter(str -> str.matches("^[A-Za-z]+$"));
		long numberOfWordsWithLatinChars = filteredStream1.count();
		System.out.println("Number of words with latin character " + numberOfWordsWithLatinChars);
		long numberOfWordsVowelEqualsConsonat = filteredStream2.filter(str -> {
			long vowelCount = str.chars().filter(element -> String.valueOf((char) element).matches("[aeoiuy]")).count();
			long consonantCount = str.chars().filter(element -> !String.valueOf((char) element).matches("[aeoiuy]"))
					.count();
			return vowelCount == consonantCount;
		}).count();
		System.out.println(
				"Number of words where vowel number equals consonant number: " + numberOfWordsVowelEqualsConsonat);

	}
	// 6. Ввести n слов с консоли. Найти слово, символы в котором идут в строгом
	// порядке возрастания их кодов.
	// Если таких слов несколько, найти первое из них.

	public static void compareCodes(String[] array) {
		Optional<String> result = Arrays.asList(array).stream().filter(str -> {
			int[] array2 = str.chars().toArray();
			for (int i = 1; i < array2.length; i++) {
				if (array2[i] <= array2[i - 1]) {
					return false;
				}
			}
			return true;
		}).findFirst();

		if (result.isPresent()) {
			System.out.println("Symbols are in Asc order " + result.get());
		}
	}

	// 7. Ввести n слов с консоли. Найти слово, состоящее только из различных
	// символов. Если таких слов несколько, найти первое из них.

	public static void onlyDistinctSymbols(String[] array) {
		Optional<String> result = Arrays.asList(array).stream().filter(str -> {
			return str.chars().distinct().toArray().length == str.length();

		}).findFirst();
		if (result.isPresent()) {
			System.out.println("All symbols are distinct: " + result.get());
		}
	}

	// 8. Ввести n слов с консоли. Среди слов, состоящих только из цифр, найти
	// слово-палиндром. Если таких слов больше одного, найти второе из них.

	public static void findPalindrome(String[] array) {
		List<String> palindromes = Arrays.asList(array).stream().filter(str -> {
			int[] array2 = str.chars().toArray();
			for (int i = 0; i < (int) array2.length / 2; i++) {
				if (array2[i] != array2[array2.length - 1 - i]) {
					return false;
				}
			}
			return true;
		}).collect(Collectors.toList());
		String result = null;
		if (palindromes.size() > 1) {
			result = palindromes.get(1);
		} else if (palindromes.size() == 1) {
			result = palindromes.get(0);
		}
		System.out.println("Palindrome: " + result);

	}

}
