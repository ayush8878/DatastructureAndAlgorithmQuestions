package BinarySearch;

import java.util.*;

/**
 * Problem: Given two unsorted array , find pair with minimum absolute difference
 *  arr1={-1,5,10,20,3}
 *  arr2={26,134,135,15,17}
 *
 *  Solution: This problem can be solved in O(MLOGM + NlogM)
 *  where MLOGM will be required to sort array2 and NLOGM to find lower bound for each arr1
 *
 *         arr1 = {-1,5,10,20,3}
 *  sorted arr2 = {15,17,26,134,135}
 *  For -1 look for lower bound in arr2 that is index 0
 *  store 16 as abs
 *  similar for 5 its 21 and 16 for 10
 *  Now for 20 closest lower bound is 26 which gives diff=6 but if we check 1 predecessor then 20-17 gives 3 that is least
 *  so in this case we will consider 3
 */
public class MinPairs {
    public static void main(String args[])
    {
        int[] arr1={-1,5,10,20,3};
        int[] arr2={26,134,135,15,17};
        int[] minPairs = findMinAbsolutePairs(arr1,arr2);
        System.out.print(Arrays.toString(minPairs));
    }

    private static int[] findMinAbsolutePairs(int[] arr1, int[] arr2) {
        // sort second array
        Arrays.sort(arr2);

        // keep diff as max
        int diff = Integer.MAX_VALUE;

        int point1 = 0;
        int point2 = 0;

         // Iterate over arr1 and
        // look for closest element in arr2
        for(int i=0;i<arr1.length;i++)
        {

            int current1 = arr1[i];
            int lb = findLowerBoundInArr2(current1,arr2);

            // lb=0 means element found in binarySearch so start with 1
            // check if abs value of current1 and lb is less than global min diff
            // this is scenario when pre-lb has lesser value
            if(lb>=1 && current1-arr2[lb-1] < diff)
            {
                // update diff
                diff = current1-arr2[lb-1];
                // update point1 and point2
                point2=current1;
                point1=arr2[lb-1];
            }
            // greater in right
            if(lb!=arr2.length && arr2[lb]-current1 < diff)
            {
                // update diff
                diff=arr2[lb]-current1;
                // update point1 and point2
                point1=current1;
                point2=arr2[lb];
            }
        }
        return new int[]{point1,point2};
    }

    /**
     * This method uses Arrays binarySearch and provide index of lower bound
     * @param current1
     * @param arr2
     * @return
     */
    private static int findLowerBoundInArr2(int current1, int[] arr2) {
        int index = Arrays.binarySearch(arr2, current1);
        if (index < 0) {
            return Math.abs(index) - 1;
        }
        return index;
    }
}
