package Array;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,3,4,-2,6,-8,3};
        int max = findMaximumSubArray(arr);
        System.out.println(max);
    }

    private static int findMaximumSubArray(int arr[])
    {
        int maxSum =0;
        int currentSum = 0;
        for(int i=0;i<arr.length;i++)
        {
            currentSum+=arr[i];
            maxSum = Math.max(currentSum,maxSum);
            // reset current sum when it's lesser than 0
            if(currentSum<0)
            {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
