import java.io.*;
import java.util.*;

class PancakeSort {
  
  static String arrayToString(int[] arr) {
    StringBuffer sb = new StringBuffer("[");
    for(int i = 0; i < arr.length; i++) {
      sb.append(arr[i]).append(", ");
    }
    
    sb.setLength(sb.length() - 2);
    return sb.append("]").toString();
  }
  
  static int[] flip(int[] arr, int k) {
    for(int i = 0, tmp = 0; i < k; i++) {
      tmp = arr[k];
      arr[k--] = arr[i];
      arr[i] = tmp;
    }
    
    return arr;
  }
  
  static int maxIndex(int[] arr, int limit) {
    int i = 0, maxIndex = 0;
    
    for(; i < limit; i++) {
      if(arr[i] > arr[maxIndex]) {
        maxIndex = i;
      }
    }
    
    return maxIndex;
  }

  static int[] pancakeSort(int[] arr) {
    for(int size = arr.length; size > 0; size--) {
      int maxIndex = maxIndex(arr, size);

      if(maxIndex != (size - 1)) {
        arr = flip(arr, maxIndex);
        arr = flip(arr, (size - 1)); // move largest value to the end of the array
      }
    }
    
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = pancakeSort(new int[] { 1, 5, 4, 3, 2 });
    //int[] arr = flip(new int[] { 1, 5, 4, 3, 2 }, 2);
    System.out.print(arrayToString(arr));
  }

}