package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5_2 {

	public static void main(String[] args) {
		System.out.println(test1("xxx"));
		System.out.println(test2("12!@"));
	}

	/*
	 * 1. Написать регулярное выражение, которое проверит, что в заданной строке
	 * содержится не более 4-х букв латинского алфавита.
	 */
	public static boolean test1(String testString) {
		Pattern p = Pattern.compile("[a-zA-Z]{0,4}");
		Matcher m = p.matcher(testString);
		return m.matches();
	}

	/*
	 * 2. Написать регулярное выражение, которое проверит, что в заданной строке
	 * содержится ровно 4 любых символа.
	 */
	public static boolean test2(String testString) {
		Pattern p = Pattern.compile(".{4}");
		Matcher m = p.matcher(testString);
		return m.matches();
	}

}
