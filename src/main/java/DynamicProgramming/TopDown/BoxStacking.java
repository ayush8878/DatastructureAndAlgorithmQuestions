package DynamicProgramming.TopDown;

import java.util.Arrays;
import java.util.Comparator;

public class BoxStacking {
    public static void main(String[] args) {
        int arr[][] = {
                {2,1,2},
                {3,2,3},
                {2,2,8},
                {2,3,4},
                {2,2,1},
                {4,4,5}
        };
        System.out.println(boxStacking(arr));
    }

    /**
     * This method will find the max height by stacking boxes
     * @param arr
     * @return
     */
    private static int boxStacking(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[2]));
        // create a memo
        int[] memo = new int[arr.length];
        // sort the array by height
        int maxHeight = 0;
        // for each box
        for(int i=0;i<arr.length;i++)
        {
            // height of current box will be the box height itself minimum
            int currentMaxHeight = arr[i][2];
            // now check for each box before the current box
            for(int j=0;j<i;j++)
            {
                // if the criteria matches then only
                if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1] && arr[i][2] > arr[j][2])
                {
                    // compare currentMaxHeight and the max height possible for the jth box + ith box height
                   currentMaxHeight = Math.max(currentMaxHeight,arr[i][2]+memo[j]);
                }
            }
            // update memo with current height
            memo[i] = currentMaxHeight;
            // update max height
            maxHeight = Math.max(maxHeight,currentMaxHeight);
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.toString(memo));
        return maxHeight;
    }
}
