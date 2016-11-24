import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class DeckShuffler {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    Hashtable<String, Integer> ht = createDeckCountHashtable();

    for (int i = 0; i < 10000000; i++) {
      int[] deck = getNewShuffledDeck();

      String deckAsString = getDeckAsString(deck);

      updateDeckCount(ht, deckAsString);
    }

    printDeckCounts(ht);

    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println(totalTime);
  }

  private static Hashtable<String, Integer> createDeckCountHashtable() {
    Hashtable<String, Integer> ht = new Hashtable<>();
    ht.put("123", 0);
    ht.put("132", 0);
    ht.put("213", 0);
    ht.put("231", 0);
    ht.put("312", 0);
    ht.put("321", 0);
    return ht;
  }

  private static int[] getNewShuffledDeck() {
    int[] deck = {1,2,3};
    deck = shuffle(deck);
//    deck = createRandomPermutation(deck); // slower because many random generations needed, but perfect uniform
    return deck;
  }

  private static String getDeckAsString(int[] deck) {
    StringBuilder sb = new StringBuilder(deck.length);
    for (int j : deck) {
      sb.append(j);
    }
    return sb.toString();
  }

  private static void updateDeckCount(Hashtable<String, Integer> ht, String deckAsString) {
    int count = ht.get(deckAsString);
    ht.replace(deckAsString, count, count + 1);
  }

  private static void printDeckCounts(Hashtable<String, Integer> ht) {
    for (String key : ht.keySet()) {
      System.out.println(key + ":" + ht.get(key));
    }
  }

  private static int[] shuffle(int[] deck) {
    for (int i = 0; i < deck.length; i++) {
      Random random = new Random();
      int randomNum = random.nextInt(i + 1); // (i+1) generates perfect uniform distribution.(deck.length) does not!

      int temp = deck[i];
      deck[i] = deck[randomNum];
      deck[randomNum] = temp;
    }
    return deck;
  }

  private static int[] createRandomPermutation(int[] deck) {
    List<Integer> list = new ArrayList<>();
    for (int e : deck) {
      list.add(e);
    }

    int[] shuffledDeck = new int[deck.length];
    for (int i = 0; i < deck.length; i++) {
      Random random = new Random();
      int randomNum = random.nextInt(list.size());
      shuffledDeck[i] = list.get(randomNum);
      list.remove(list.get(randomNum));
    }

    return shuffledDeck;
  }

}
