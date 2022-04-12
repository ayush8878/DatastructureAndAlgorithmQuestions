package SortingAndSearching;

import java.util.*;
public class QuickSort {
    public static void main(String args[])
    {
        int[] arr = {10,5,2,0,7,6,4};
        System.out.println("Before Sort:"+Arrays.toString(arr));
        quickSort(arr);
        System.out.println("After Sort:"+Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end)
    {
        // Base Case
        if(start>=end)
        {
            return;
        }
        // identify pivot
        int pivot = partition(arr,start,end);
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);
    }

    private static int partition(int[] arr, int start, int end) {
        int i = start-1;
        int pivot = arr[end];

        for(int j=start;j<end;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        int temp = arr[end];
        arr[end]=arr[i+1];
        arr[i+1]=temp;
        return i+1;
    }
}
