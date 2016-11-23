import java.util.*;
import java.lang.*;
import java.io.*;

class URLify {
	public static void main (String[] args) throws java.lang.Exception {
		String str = "Mr John Smith    ";
		int length = 13;
		System.out.print(urlify(str, length));
	}
 
	static String urlify(String str, int length) {
		char[] charArr = new char[str.length()];
		int j = 0;
		for(int i = 0; i < length; i++) {
			if ( str.charAt(i) == ' ') {
				charArr[j] = '%';
				charArr[j + 1] = '2';
				charArr[j + 2] = '0';
				j += 2;
			} else {
				charArr[j] = str.charAt(i);
			}
			j += 1;
		}
		return String.valueOf(charArr);
	}
  
}
