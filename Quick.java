import java.io.*;
import java.util.*;

public class Quick {

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

    //generate random index (0-length)


    int lo = data[start];
    int hi = data[end];
    int mid  = data[(end-start)/2];

    int[] vals = {lo,hi,mid};

    Arrays.sort(vals);
    int pivot = vals[1];
    int pIdx = 0;

    if (pivot == lo) pIdx = start;
    else if (pivot == hi) pIdx = end;
    else if (pivot == mid) pIdx = ((end-start)/2);

    //System.out.println(Arrays.toString(data));
    //System.out.println("pivot: "+pivot+" IDX: "+pIdx);


    /*
    int pIdx = (int) (Math.random() * (end - start + 1)) + start;
    //System.out.println(pIdx);
    int pivot = data[pIdx]; */
    //System.out.println(pivot);

    //place pivot at beginning, swap.
    swap(data,start,pIdx);

    //loop through ints from start to end
    int i1 = start+1; // last index of a number smaller than pivot.
    int i2 = end;

    int dup = 0;

    while (i2 > i1) {
      //System.out.println("\n"+i1+", "+i2);
      //System.out.println(Arrays.toString(data));

      if (data[i1] > pivot) {
        swap(data,i2,i1);
        i2--;
      }
      if (data[i1] == pivot) {
        //generating random int 0 or 1.
        /*
        Random r = new Random();
        int move = r.nextInt(2);
        */
        //System.out.println(move);

        if (dup == 0) { //keep at front
            i1++;
            dup ++;
        } else {
          swap(data,i2,i1);
          i2--;
          dup = 0;
        }
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
    if (pivot > data[i1]) {
      swap(data,i1,start);
      return i1;
    } else {
      swap(data,i1-1,start);
      return i1-1;
    }
    //System.out.println(Arrays.toString(data));
    //System.out.println(i1);
    //System.out.println("pivot: "+i2);

    //now loop through data to place pivot.
    /*
    int idx = end;
    for (int i=start+1;i<=end;i++) {
      if (pivot < data[i]) {
        //System.out.println("i: "+i);

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


  }*/

  //swap(data,start,idx);
  //System.out.println("value: "+pivot);
  //System.out.println("index: "+(idx));System.out.println(Arrays.toString(data)+"\n");
  //return idx;
}

  private static int[] partitionDutch(int[] data, int start, int end){
    //your code

    //generating pivot point based on first,middle,last element's median.
    int low = data[start];
    int hig = data[end];
    int mid  = data[(end-start)/2];

    int[] vals = {low,hig,mid};

    Arrays.sort(vals);
    int pivot = vals[1];
    int pIdx = 0;

    if (pivot == low) pIdx = start;
    else if (pivot == hig) pIdx = end;
    else if (pivot == mid) pIdx = ((end-start)/2);

    swap(data,start,pIdx);
    int i=start+1; // current index.
    int gt = end; // first index of greater values
    int lt = start; // last index of smaller values

    while (gt > i) {

      //if current is greater than pivot,
      if (data[i] > pivot) {
        swap(data,i,gt-1);
        gt--;

      }
      //if current is less than pivot, swap current for first duplicate.
      if (data[i] < pivot) {
        if (i == lt+1) { // means that there have been no duplicates yet
          i++;
          lt++;
        } else {
          swap(data,i,lt+1);
          lt++;
          i++;
        }
      }
      //if current is equal to pivot, just increment i.
      if (data[i] == pivot) i++;

    }




    int[] result = {lt-1,gt};
    swap(data,start,lt);

    //System.out.println(Arrays.toString(data));
    //System.out.println(Arrays.toString(result));



    return result;
    //return an array [lt,gt]
}

  /*return the value that is the kth smallest value of the array.
*/
  public static int quickselect(int[] data, int k){
    //System.out.println("Finding element "+k);
    int pivot = partition(data,0,data.length-1);
    //int temp = pivot;
    int lastS = 0;
    int lastE = data.length-1;
    for (int i=0;i<data.length;i++) {

      //temp = pivot;

      /*
      System.out.println("pivot: "+pivot);
      System.out.println("\ttemp: "+temp);
      System.out.println(Arrays.toString(data));
      */
      //temp = pivot;

      //System.out.println("BETWEEN "+lastS+", "+lastE);
      if (pivot == k) return data[pivot];

      if (lastS == lastE) return data[pivot];


      //if (pivot < k) pivot = partition(data,temp+1,data.length-1);
      /*
      if (pivot > k) {
        pivot = partition(data,0,temp-1);
      }*/

      if (pivot < k) {
        //System.out.println("Checking between "+(temp+1)+", "+lastE);
        if ((pivot+1) == lastE) return data[lastE];
        lastS = pivot+1;
        pivot = partition(data,pivot+1,lastE);
      }

      if (pivot > k) {
        //System.out.println("\n\tpivot: "+pivot);
        //System.out.println("checking between "+lastS+", "+(pivot-1));
        if ((pivot-1) == lastS) return data[lastS];
        lastE = pivot-1;
        pivot = partition(data,lastS,pivot-1);
      }

    }
    return -1;
  }

  public static void dutchSort(int[] data) {
    int[] pivots = partitionDutch(data,0,data.length-1);
    int p1 = pivots[0];
    int p2 = pivots[1];

    if (p1 == 0 && p2 == data.length-1) return; //because every value was a duplicate of pivot.

    if (p1 == 0) { //no values smaller than pivot were found, so only partition greater values.
      partitionDutch(data,p2,data.length-1);
    } else if (p2 == data.length-1) { // no values greater than pivot were found, so only partition smaller values.
      partitionDutch(data,0,p1);
    } else { // distribution.. so partition smaller values and greater values but not duplicates.
      partitionDutch(data,0,p1);
      partitionDutch(data,p2,data.length-1);
    }
  }

  public static void dutchSort(int[] data, int i1, int i2) {
    if (i1 == i2) return;
    int[] pivots = partitionDutch(data,i1,i2);
    int p1 = pivots[0];
    int p2 = pivots[1];


    if (p1 == i1 && p2 == i2) { // every value was a duplicate of pivot
      return;
    }
    if (p1 == i1) { //no values smaller than pivot were found, so only partition greater values.
      partitionDutch(data,p2,i2);
    } else if (p2 == i2) { // no values greater than pivot were found, so only partition smaller values.
      partitionDutch(data,i1,p1);
    } else { // distribution.. so partition smaller values and greater values but not duplicates.
      partitionDutch(data,i1,p1);
      partitionDutch(data,p2,i2);
    }
  }

   public static void quicksort(int[] data) {
     int pivot = partition(data,0,data.length-1);
     if (pivot == 0) {
       quicksort(data,pivot+1,data.length-1);
     } else if (pivot == data.length-1) {
       quicksort(data,0,pivot-1);
     } else {
       quicksort(data,0,pivot-1); // exclude pivot because it's already sorted.
       quicksort(data,pivot+1,data.length-1);
     }

     //int p2 = partition(data,(data.length/2),data.length-1);


   }

   public static void quicksort(int[] data, int i1, int i2) {
     if (i1 == i2) return;
     int pivot = partition(data,i1,i2);

     if (pivot == i1) {
       quicksort(data,pivot+1,i2);
     } else if (pivot == i2) {
       quicksort(data,i1,pivot-1);
     } else {
       quicksort(data,i1,pivot-1);
       quicksort(data,pivot+1,i2);
     }
   }

  public static void main(String[] args) {
    int[] data = {100,98,99,98,98,4,2,98,7,98};
    dutchSort(data);
    System.out.println(Arrays.toString(data));
/*
    for (int i=0;i<10;i++) {
      System.out.println(partition(data,0,5));
    }*/

/*
    for (int i=0;i<10;i++) {
      Random r = new Random();
      int move = r.nextInt(2);
      System.out.println(move);
    }
    quicksort(data);
    System.out.println(Arrays.toString(data));
    */
    //System.out.println(quickSelect(data,3));
      //System.out.println("QUICKSELECT: "+quickSelect(data,3));

      //System.out.println(quickselect(data,3));

    //}

}
}
