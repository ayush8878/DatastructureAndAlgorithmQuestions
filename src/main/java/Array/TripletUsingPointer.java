package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletUsingPointer {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,15};
        int targetSum = 18;
        System.out.println("Triplets for arr:"+Arrays.toString(arr)+" for sum= "+targetSum+" are:");
        List<List<Integer>> triplets = findTriplet(targetSum,arr);
        System.out.println(triplets);
    }

    private static List<List<Integer>> findTriplet(int targetSum, int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            int base = arr[i];
            int front = i+1;
            int back = arr.length - 1;
            while(front < back)
            {
                if(arr[front] + arr[back] + arr[base] == targetSum)
                {
                    triplets.add(Arrays.asList(arr[base],arr[front],arr[back]));
                    front++;
                    back--;
                }
                else if(arr[front] + arr[back] + arr[base] > targetSum)
                {
                    back--;
                }
                else
                {
                    front++;
                }
            }
        }
        return triplets;
    }
}
