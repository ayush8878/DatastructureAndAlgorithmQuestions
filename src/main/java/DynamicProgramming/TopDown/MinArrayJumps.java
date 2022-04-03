package DynamicProgramming.TopDown;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinArrayJumps {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,2,1,2,3,7,1,1,1,3};
        int[] memo = new int[arr.length];
        System.out.println(findMinimumJumps(arr,11,memo,0));
    }

    private static int findMinimumJumps(int[] arr, int n,int[] memo,int currentIndex) {
        // base condition
        if(currentIndex == n-1)
        {
            return 0;
        }
        // edge condition
        if(currentIndex >= n)
        {
            return Integer.MAX_VALUE;
        }
        // check in memo if already present
        if(memo[currentIndex] != 0)
        {
            return memo[currentIndex];
        }
        //logic
        int stepsRequired  = Integer.MAX_VALUE;
        // max jump possible from current index
        int maxJumps = arr[currentIndex];

        // check for min steps based on each jump
        for(int jump = 1 ; jump <= maxJumps ; jump++)
        {
            // next index from current index
            int nextIndex = currentIndex + jump;
            // check for min steps in sub problem
            int subProblem = findMinimumJumps(arr,n,memo,nextIndex);
            // if in case sub problem is max_values that means it was going out of bound
            if(subProblem != Integer.MAX_VALUE)
            {
                // check min among the existing steps and sub problem + 1 steps
                stepsRequired = Math.min(stepsRequired,subProblem+1);
            }
        }
        // update memo
        memo[currentIndex] = stepsRequired;
        return stepsRequired;
    }
}
