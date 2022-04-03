package DynamicProgramming.TopDown;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = new int[]{50,4,10,8,30,100};
        System.out.println(findLongestIncreasingSubsequence(arr));

        List<Integer> temp = new ArrayList<>();
    }

    private static int findLongestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] memo = new int[n];
        // initialize memo[0] to 1 as it's the min len possible
        memo[0] = 1;
        int maxLength = 1;
        // for each element of array
        for(int i = 1;i<n;i++)
        {
            // for each element before i
            for(int j = 0;j<i;j++)
            {
                // if in case it's an increasing subsequence then only
                if(arr[i] > arr[j])
                {
                    // take maximum among the current memo or 1 plus j
                    memo[i] = Math.max(1+memo[j],memo[i]);
                    // update maxLength
                    maxLength = Math.max(maxLength,memo[i]);
                }
            }
        }
        return maxLength;
    }
}
