package SortingAndSearching;

import java.util.Arrays;

public class QuickSelect {
    public static void main(String args[])
    {
        int[] arr = {10,5,2,0,7,6,4};
        int k =4;
        int kthSmallest = quickSort(arr,k);
        System.out.println("Kth Smallest:"+kthSmallest);
    }

    private static int quickSort(int[] arr,int k) {
        return quickSort(arr,0,arr.length-1,k);
    }

    private static int quickSort(int[] arr, int start, int end,int k)
    {
        // identify pivot
        int pivot = partition(arr,start,end);
        if(pivot == k)
        {
            return arr[pivot];
        }
        else if(k<pivot)
        return quickSort(arr,start,pivot-1,k);
        else
        return quickSort(arr,pivot+1,end,k);
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
