import java.io.*;
import java.util.*;

public class QuickTemp {

  private static void swap(int[] data, int i1, int i2) {
    int temp = data[i1];
    data[i1] = data[i2];
    data[i2] = temp;
  }
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
    swap(data,start,pIdx);

    //loop through ints from start to end
    int i1 = start+1; // last index of a number smaller than pivot.
    int i2 = end;
    while (i2 >= i1) {
      System.out.println("\n"+i1+", "+i2);
      System.out.println(Arrays.toString(data));

      if (data[i1] >= pivot) {
        swap(data,i2,i1);
        i2--;
      }
      /*
      //if data[i2] is proper, increment i2
      /*
      if (data[i2] >= pivot) {
        i2--;
<<<<<<< HEAD
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
    int idx = end;
    for (int i=start+1;i<=end;i++) {
      if (pivot < data[i]) {
        System.out.println("i: "+i);

        idx = i-1;
        i = end+1;

      }

        /*
    for (int i=start;i<=end;i++) {
      if (pivot > data[i]) {
        int temp = data[i-1];
        data[i-1] = pivot;
        data[start] = temp;
        i = end+1; // break out of loop.
        return i-1;

      }
    }
    */
    /*
    int temp = data[i2-1]; // data[i2] is the last value smaller than pivot. swap it with pivot.
    data[start] = temp;
    data[i2-1] = pivot;
    */
/*
    System.out.println("index: "+i2);
    System.out.println(Arrays.toString(data)+"\n");
    return i2-1;
    */

  }
  swap(data,start,idx);
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
      int temp = pivot;
      System.out.println("pivot: "+pivot);
      System.out.println(Arrays.toString(data));
      temp = pivot;

      if (pivot == k) return data[pivot];


      //if (pivot < k) pivot = partition(data,temp+1,data.length-1);

      if (pivot > k) pivot = partition(data,0,temp-1);

      if (pivot < k) {
        System.out.println("checking between "+(temp+1)+", "+(data.length-1));
        pivot = partition(data,temp+1,data.length-1);
      }

      if (pivot > k) {
        System.out.println("checking between 0, "+(temp-1));
        pivot = partition(data,0,temp-1);
      }

    }
    return -1;
  }

  public static void main(String[] args) {
    int[] data = {100,99,98,4,2,7};
    for (int i=0;i<10;i++) {
      System.out.println(partition(data,0,5));
    }
      //System.out.println("QUICKSELECT: "+quickSelect(data,3));

    //  quickSelect(data,3);

    //}

}
}
