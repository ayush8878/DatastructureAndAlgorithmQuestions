package HashTable;

import java.util.*;
public class PairSumCheck
{
    public static void main(String args[])
    {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int k = 4;
        int pairSum = getPairSum(k,arr);
        System.out.print(pairSum);
    }

    private static int getPairSum(int k,int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();
        // Put all elements in set so that k - i will be present in set
        for(int i = 0; i<arr.length ; i++)
        {
            set.add(arr[i]);
        }
        // For each element in array check if k - i is present in set
        for(int i=0;i<arr.length;i++)
        {
            if(set.contains(k - arr[i]))
            {
                return k;
            }
        }
        return -k;
    }
}