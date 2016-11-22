import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args){
    int[] arr = {3, 1, 2, 7, 0, 1, 23, 23, -4};
    System.out.println("sort this " + Arrays.toString(arr));
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));

    System.out.println();

    int[] arr2 = {};
    System.out.println("check empty array " + Arrays.toString(arr2));
    bubbleSort(arr2);
    System.out.println(Arrays.toString(arr2));
  }

  private static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = n - 1; i > 0; i--) {
      for(int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
          arr = swap(arr, j);
        }
      }
    }
  }

  private static int[] swap(int[] arr, int j) {
    int temp = arr[j];
    arr[j] = arr[j + 1];
    arr[j + 1] = temp;
    return arr;
  }

}