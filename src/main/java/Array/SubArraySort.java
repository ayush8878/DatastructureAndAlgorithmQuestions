package Array;

import java.util.Arrays;

public class SubArraySort {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,8,6,7,9,10,11};
        int[] unsortedRange = findUnsortedSubArray(arr);
        System.out.print(Arrays.toString(unsortedRange));
    }
    private static int[] findUnsortedSubArray(int[] arr)
    {
        int[] result = new int[2];
        int smallest = Integer.MAX_VALUE;
        int largest =  Integer.MIN_VALUE;
        // find smallest and largest that are out of order
        for(int i=0;i<arr.length;i++)
        {
            if(outOfOrder(arr,i))
            {
                smallest = Math.min(smallest,arr[i]);
                largest = Math.max(largest,arr[i]);
            }
        }
        // traverse from left and find correct position of smallest
        int left = 0;
        while(arr[left]<smallest)
        {
            left++;
        }
        int right = arr.length -1;
        // traverse from right and find correct position of largest
        while (arr[right] > largest)
        {
            right--;
        }
        result[0] = left;
        result[1]=right;
        return result;
    }

    private static boolean outOfOrder(int []arr,int i)
    {
        // handle edge case of left
       if(i == 0 )
       {
           return arr[i] > arr[i+1];
       }
       // handle edge case of right
       else if(i == arr.length-1)
       {
            return  arr[i] < arr[i-1];
       }
       return arr[i] > arr[i+1] || arr[i] < arr[i-1];
    }
}
