package name.kazennikov.common;

import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;

import java.util.ArrayList;
import java.util.List;

public class StringTools {
	
	/**
	 * Convert a string into a list of characters
	 * @param s string to convert
	 * @return resulting list
	 */
	public static List<Character> explode(String s) {
		List<Character> list = new ArrayList<Character>(s.length());
		
		for(int i = 0; i < s.length(); i++)
			list.add(s.charAt(i));
		
		return list;
	}
	
	
	/**
	 * Convert a list of characters into a string
	 * @param list source array to convert
	 * @return resulting string
	 */
	public static String implode(List<Character> list) {
		StringBuilder sb = new StringBuilder(list.size());
		
		for(Character ch : list)
			sb.append(ch);
		
		return sb.toString();
	}
	
	/**
	 * Splits a string with a char separator
	 * @param s string to parse
	 * @param sep separator
	 * @param skipEmpty if true, skip empty result string
	 * @return list of splitted strings
	 */
	public static List<String> split(String s, char sep, boolean skipEmpty) {
		List<String> parts = new ArrayList<String>();
		int last = 0;
		for(int i = 0; i != s.length(); i++) {
			if(s.charAt(i) == sep) {
				if(!skipEmpty || last != i)
					parts.add(s.substring(last, i));
				last = i + 1; // after the sep

			}
		}
		if(last != s.length())
			parts.add(s.substring(last, s.length()));
		return parts;
	}
	
	public static TIntList toIntList(CharSequence s) {
		TIntList l = new TIntArrayList();
		
		for(int i = 0; i < s.length(); i++) {
			l.add(s.charAt(i));
		}
		
		return l;
	}

	/**
	 * Replace all occurences of string from to string to in s
	 * @param s base string
	 * @param from replace from string
	 * @param to replace to string
	 * @return string with made replacements
	 */
	public static String replace(String s, String from, String to) {
		int index = 0;
		StringBuilder out = new StringBuilder();
		
		while(index < s.length()) {
			int next = s.indexOf(from, index);
			if(next == -1) {
				out.append(s, index, s.length());
				break;
			} 
			
			out.append(s, index, next);
			out.append(to);
			index = next + from.length();
		}

		return out.toString();
	}

	


}
