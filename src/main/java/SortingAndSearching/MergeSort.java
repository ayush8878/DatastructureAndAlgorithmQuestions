package SortingAndSearching;

import java.util.*;
public class MergeSort {

    public static void main(String args[])
    {
        int[] arr={10,5,2,0,7,6,4};
        System.out.println("Before Sorting: "+Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("After Sorting: "+Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        if(arr.length == 1)
        {
            return;
        }
        // sort from start to end
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int start, int end)
    {
        // if 1 element only
        if(end - start == 0)
        {
            return;
        }
        // for 2 element
        else if(end - start == 1)
        {
            // if start is less then no need to swap
            if(arr[start] < arr[end])
            {
                return;
            }
            // swap
            else
            {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start]=temp;
                return;
            }
        }
        else
        {
            int mid = (start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i =start;
        int j=mid+1;
        // temp array
        int[] temp=new int[end-start+1];
        // counter
        int tempC = 0;
        // while both subarray are not traversed
        while(i<=mid && j<=end)
        {
            if(arr[i] < arr[j])
            {
               temp[tempC] = arr[i];
                i++;
            }
            else if(arr[i] > arr[j])
            {
                temp[tempC] = arr[j];
                j++;
            }
            tempC++;
        }
        while(i<=mid)
        {
            temp[tempC] = arr[i];
            i++;
            tempC++;
        }
        while(j<=end)
        {
            temp[tempC] = arr[j];
            j++;
            tempC++;
        }
        for(int k=0;k<temp.length;k++)
        {
            arr[start]=temp[k];
            start++;
        }
    }
}
