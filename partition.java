import java.io.*;
import java.util.*;

public class partition {

  /*Modify the array such that:
*1. Only the indices from start to end inclusive are considered in range
*2. A random index from start to end inclusive is chosen, the corresponding
*   element is designated the pivot element.
*3. all elements in range that are smaller than the pivot element are placed before the pivot element.
*4. all elements in range that are larger than the pivot element are placed after the pivot element.
*@return the index of the final position of the pivot element.
*/
  public static int partition ( int[] data, int start, int end){

    //generate random index (0-length)
    int pIdx = (int) (Math.random() * (end - start + 1)) + start;
    //System.out.println(pIdx);
    int pivot = data[pIdx];
    System.out.println(pivot);

    //place pivot at beginning, swap.
    data[pIdx] = data[start];
    data[start] = pivot;

    //loop through ints from start to end
    int i1 = start+1; // last index of a number smaller than pivot.
    int i2 = end;
    while (i2 > i1) {
    //  System.out.println(i1+", "+i2);
    //  System.out.println(Arrays.toString(data));

      if (data[i1] >= pivot) {
        int temp = data[i1];
        //move the larger value to end of array (swap)
        System.out.println("swapping "+data[i1]+" with "+data[i2]);
        data[i1] = data[i2];
        data[i2] = temp;
        i2--;
      }
      if (data[i2] >= pivot) {
        i2--;
      }
      if (data[i1] < pivot) {
        i1++;
      }
    }
    System.out.println(Arrays.toString(data));




    return 0;
  }

  public static void main(String[] args) {
    int[] data = {1,7,4,2,3,6,5,4,2,7,5};
    //for (int i=0;i<10;i++) {
      partition(data,0,10);

    //}
  }
}
