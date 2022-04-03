package DynamicProgramming.TopDown;

import java.util.Arrays;

public class MaxNonAdjSum {

    public static void main(String[] args) {
        int[] arr = new int[]{6,10,12,7,9,14};
        // int[] arr = new int[]{1,2,3,4,5};
        // here it is imp to send -2 so that 0 will get considered in solution
        int[]memo = new int[arr.length+1];
        memo[0] = 0;
        System.out.println(findMaxNonAdjSum(arr,-2));
        System.out.println(findMaxNonAdjSumTopDownDp(arr,-2,memo));
        System.out.println(findMaxNonAdjSumBottomUp(arr));
    }

    public static int findMaxNonAdjSum(int[] arr,int index) {
     // in case index goes out of bound return 0
     if(index >= arr.length - 1)
     {
         return 0;
     }
     // consider max as int min
     int max = Integer.MIN_VALUE;
     // as we need to skip next element initialize i with +2
     for(int i = index + 2; i < arr.length ; i++)
     {
         // find max for sub-problem
         int subproblem = findMaxNonAdjSum(arr,i);
         // consider the sub-problem sum and current value in arr
         max = Math.max(max,subproblem+arr[i]);
     }
     return max;
    }

    public static int findMaxNonAdjSumTopDownDp(int[] arr,int index,int[] memo) {
        if(index >= arr.length - 1)
        {
            return 0;
        }
        if(memo[index+2] != 0)
        {
            return memo[index+2];
        }
        int max = Integer.MIN_VALUE;
        for(int i = index + 2; i < arr.length ; i++)
        {
            int subproblem = findMaxNonAdjSumTopDownDp(arr,i,memo);
            max = Math.max(max,subproblem+arr[i]);
        }
        memo[index+2] = max;
        return max;
    }

    private static int findMaxNonAdjSumBottomUp(int[] arr) {
        if(arr.length == 1)
        {
            // considering negative numbers by not choosing anything
            return Math.max(0,arr[0]);
        }
        else if(arr.length == 2)
        {
            // if in-case there are 2 no then one among them can only be picked
            return Math.max(0,Math.max(arr[0] ,arr[1]));
        }
        int[] memo = new int[arr.length+1];
        // Bottom Up Logic
        memo[0] = Math.max(0,arr[0]);
        memo[1] = Math.max(0,Math.max(arr[0] ,arr[1]));

        for(int i =2; i<arr.length;i++)
        {
            int inc = arr[i] +  memo[i-2];
            int exc = memo[i-1];
            memo[i] = Math.max(inc,exc);
        }
        return memo[arr.length-1];
    }
}
