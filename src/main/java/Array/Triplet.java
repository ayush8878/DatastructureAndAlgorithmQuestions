package Array;

        import java.util.*;
        import java.util.Arrays;
class Triplet
{
    public static void main(String args[])
    {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,15};
        int targetSum = 18;
        triplets(targetSum,arr);
    }

    private static void triplets(int targetSum,int []arr)
    {
        System.out.print("Array is +"+ arr);
        HashSet<Integer> set = new HashSet<>();
        // add all elements to set
        for(int i= 0 ; i< arr.length;i++)
        {
            set.add(arr[i]);
        }
        // sort array
        //Arrays.sort(arr);
        // pick one element and find remaining in set
        for(int i= 0 ; i< arr.length;i++)
        {
            for(int j = i+1; j<arr.length;j++)
            {
                if(set.contains(targetSum - (arr[i]+arr[j])))
                {
                    // TODO: Fix issue with multiple repeat
                    System.out.print("Found triplet: "+arr[i]+" "+arr[j]+" "+ (targetSum - (arr[i]+arr[j])));
                }
            }
        }
    }
}
