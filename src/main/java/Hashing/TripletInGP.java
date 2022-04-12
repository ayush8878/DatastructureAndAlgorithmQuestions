package Hashing;

import java.util.HashMap;

/**
 * In this problem we need to find triplets in GP in a given array
 * For below example 16 is the centre of GP 4 is left and 64 is right
 */
public class TripletInGP {
    public static void main(String[] args) {
        int[] arr = {16,4,16,16,64,16};
        int[] arr2 = {4,2,10,4,8,20,40};
        int r2 = 2;
        // Common Ratio of GP
        int r = 4;
        System.out.println("No in GP is = "+findNoInGP(arr,r));
    }

    private static int findNoInGP(int[] arr,int r) {
        HashMap<Integer,Integer> leftMap = new HashMap<>();
        HashMap<Integer,Integer> rightMap = new HashMap<>();
        // populate left map as empty and right map as total count of value
        for(int x:arr)
        {
            leftMap.put(x,0);
            rightMap.put(x,rightMap.getOrDefault(x,0)+1);
        }

        // iterate over array
        for(int centre:arr)
        {
            // left of GP
            int left = centre/r;
            // right of GP
            int right = centre*r;
            // check in left map if there is any element that matched left value and in right matches right value
            if(leftMap.getOrDefault(left,0) > 0 && rightMap.getOrDefault(right,0) > 0)
            {
                return centre;
            }
            // if it does not match then move the element from right to left map
            else
            {
                leftMap.put(centre,leftMap.getOrDefault(centre,0)+1);
                rightMap.put(centre,rightMap.getOrDefault(centre,0)-1);
            }
        }
        return -1;
    }
}
