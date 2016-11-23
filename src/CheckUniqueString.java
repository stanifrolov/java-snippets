
import java.util.*;
import java.lang.*;
import java.io.*;

class CheckUniqueString
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String s = "afgada";
		System.out.print(isUnique(s));
		
		s = "";
		System.out.print(isUnique(s));
		
		s = "abc";
		System.out.print(isUnique(s));
	}
	
	public static boolean isUnique(String s) {
		 Hashtable<Character, Boolean> ht = new Hashtable<Character, Boolean>();
		 for(int i = 0; i < s.length(); i++) {
		 	char c = s.charAt(i);
		 	boolean htContainsChar = ht.containsKey(c);
		 	if (htContainsChar) {
		 		return false;
		 	} else {
		 		ht.put(c, true);
		 	}
		 }
		 return true;
	}
}
