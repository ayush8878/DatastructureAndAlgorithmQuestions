package Sort;

import java.util.Arrays;
public class BubbleSort
{
    public static void main(String args[])
    {
        int arr[] = new int[]{1,2,3,4,5,7,6};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted : "+Arrays.toString(arr));
    }

    private static void bubbleSort(int arr[])
    {
        boolean swapped = false;
      for(int i=0;i<arr.length;i++)
      {
          for(int j=i+1;j<arr.length;j++)
          {
              if(arr[i] > arr[j])
              {
                  int temp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = temp;
                  swapped = true;
              }
          }
          if(!swapped)
          {
              System.out.println("Already Sorted : "+Arrays.toString(arr));
              return;
          }
      }
    }
}