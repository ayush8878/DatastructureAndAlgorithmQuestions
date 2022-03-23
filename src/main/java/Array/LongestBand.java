package Array;

import java.util.*;
import java.util.stream.Collectors;

public class LongestBand {

    public static void main(String[] args) {
        //int[] arr = new int[]{1,9,3,0,18,5,2,4,10,7,12,6} ;
        int[] arr = new int[]{5,4,3,2,1} ;
        int longestBand = findLongestBand(arr);
        System.out.println(longestBand);

    }

    private static int findLongestBand(int[] arr) {
        int result = 0;
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            // if there is no element in set before current element
            if(!set.contains(arr[i]-1))
            {
                int count = 1;
                int next= arr[i]+1;
                // look for all the elements forward to current element
                while(set.contains(next))
                {
                    count++;
                    next++;
                }
                result = (result < count)?count:result;
            }
        }
        return result;
    }
}
