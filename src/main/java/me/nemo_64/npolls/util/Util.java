package me.nemo_64.npolls.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

	public static String deleteSpacesAtBeginingAndEnding(String str) {
		return reverse(deleteSpacesAtBeginign(reverse(deleteSpacesAtBeginign(str))));
	}

	public static String deleteSpacesAtBeginign(String s) {
		char[] array = s.toCharArray();
		int i = 0;
		while (array[i] == ' ')
			i++;
		return new String(Arrays.copyOfRange(array, i, array.length));
	}

	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	public static String join(String[] args) {
		if (args.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		sb.append(args[0]);
		for (int i = 1; i < args.length; i++) {
			sb.append(" ");
			sb.append(args[i]);
		}

		return sb.toString();
	}

	public static String[] split(String s, char splitOn) {
		boolean ignoreHyphen = false;
		StringBuilder builder = new StringBuilder();
		final List<String> retStrings = new ArrayList<>();
		for (char c : s.toCharArray()) {
			if (c == '\\') {
				ignoreHyphen = true;
			} else if (c == splitOn && !ignoreHyphen) {
				if (builder.length() <= 0)
					continue;
				retStrings.add(builder.toString());
				builder = new StringBuilder();
			} else {
				builder.append(c);
				ignoreHyphen = false;
			}
		}
		if (builder.length() > 0)
			retStrings.add(builder.toString());
		return retStrings.toArray(new String[retStrings.size()]);
	}

}
