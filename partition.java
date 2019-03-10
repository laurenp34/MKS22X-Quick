public class partition {

  /*Modify the array such that:
*1. Only the indices from start to end inclusive are considered in range
*2. A random index from start to end inclusive is chosen, the corresponding
*   element is designated the pivot element.
*3. all elements in range that are smaller than the pivot element are placed before the pivot element.
*4. all elements in range that are larger than the pivot element are placed after the pivot element.
*@return the index of the final position of the pivot element.
*/
  public static int partition ( int [] data, int start, int end){

    //generate random index (0-length)
    int pIdx = (int) (Math.random() * data.length);
    System.out.println(pIdx);

    return 0;
  }

  public static void main(String[] args) {
    int[] data = {1,2,3,4,5,6,7};

    for (int i=0;i<20;i++) {
      partition(data,0,0);
    }
  }
}
