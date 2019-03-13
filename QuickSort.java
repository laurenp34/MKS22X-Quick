import java.io.*;
import java.util.*;

public class QuickSort {

  /*Modify the array such that:
*1. Only the indices from start to end inclusive are considered in range
*2. A random index from start to end inclusive is chosen, the corresponding
*   element is designated the pivot element.
*3. all elements in range that are smaller than the pivot element are placed before the pivot element.
*4. all elements in range that are larger than the pivot element are placed after the pivot element.
*@return the index of the final position of the pivot element.
*/
  public static int partition ( int[] data, int start, int end){

    //generate random index (0-length)nt
    int pIdx = (int) (Math.random() * (end - start + 1)) + start;
    //System.out.println(pIdx);
    int pivot = data[pIdx];
    //System.out.println(pivot);

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
        //System.out.println("swapping "+data[i1]+" with "+data[i2]);
        data[i1] = data[i2];
        data[i2] = temp;
        i2--;
      }
      /*
      //if data[i2] is proper, increment i2
      if (data[i2] >= pivot) {
        i2--;
      }*/
      //if data[i1] is proper increment it.
      if (data[i1] < pivot) {
        i1++;
      }

    }
    //System.out.println(Arrays.toString(data));
    //System.out.println(i1);
    //System.out.println("pivot: "+i2);

    //now loop through data to place pivot.
    int idx = 0;
    for (int i=start+1;i<=end;i++) {
      if (pivot < data[i]) {
        int temp = data[i-1];
        data[i-1] = pivot;
        data[start] = temp;
        idx = i-1;
        System.out.println("value: "+pivot);
        System.out.println("index: "+(idx));System.out.println(Arrays.toString(data)+"\n");
        return idx;

      }
    }
    /*
    int temp = data[i2-1]; // data[i2] is the last value smaller than pivot. swap it with pivot.
    data[start] = temp;
    data[i2-1] = pivot;
    */

    System.out.println("value: "+pivot);
    System.out.println("index: "+(idx));System.out.println(Arrays.toString(data)+"\n");
    return idx;
  }

  /*return the value that is the kth smallest value of the array.
*/
  public static int quickSelect(int[] data, int k){
    System.out.println("Finding element "+k);
    int pivot = partition(data,0,data.length-1);
    for (int i=0;i<data.length;i++) {
      System.out.println("pivot: "+pivot);
      System.out.println(Arrays.toString(data));
      int temp = pivot;

      if (pivot == k) return data[pivot];

      if (pivot < k) pivot = partition(data,temp+1,data.length-1);

      if (pivot > k) pivot = partition(data,0,temp-1);
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] data = {100,99,98,4,2,7};
    //for (int i=0;i<10;i++) {
    for (int i=0;i<10;i++)
      System.out.println("QUICKSELECT: "+quickSelect(data,3));

    //}
  }
}
