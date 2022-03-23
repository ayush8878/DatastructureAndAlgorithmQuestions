package Array;

import java.util.Arrays;

public class MinimumDifference {
    static class Pair
    {
        public int key;
        public int index;

        Pair(int key, int index)
        {
            this.key = key;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int []arr1 = new int[]{23,5,10,17,30};
        int []arr2 = new int[]{26,134,135,14,19};
        Pair minPair = getMinimumDifferencePair(arr1,arr2);
    }

    private static Pair getMinimumDifferencePair(int[] arr1,int[] arr2)
    {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int curr1 = 0;
        int curr2 = 0;
        int minAbsoluteDiff = 0;
        while(curr1 < arr1.length || curr2 < arr2.length)
        {
            minAbsoluteDiff = Math.min(minAbsoluteDiff,Math.abs(arr1[curr1]-arr2[curr2]));

        }
        // incomplete
        return null;
    }
}
