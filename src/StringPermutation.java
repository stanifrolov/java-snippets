public class StringPermutation {

  public static void main (String[] args){
    System.out.println("Hello World!");
    permutation("abcd");
  }

  private static void permutation(String str) {
    permutation(str, "");
  }

  private static void permutation(String str, String prefix) {
    if (str.length() == 0) {
      System.out.println(prefix);
    } else {
      for (int i = 0; i < str.length(); i++) {
        String rem_1 = str.substring(0, i);
        String rem_2 = str.substring(i + 1);
        String rem = rem_1 + rem_2;
        String newPrefix = prefix + str.charAt(i);
        permutation(rem, newPrefix);
      }
    }
  }

}