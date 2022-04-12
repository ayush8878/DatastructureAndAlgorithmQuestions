package SlidingWindow;

/**
 * In this program find the total no of plots possible of square ft k
 */
public class Housing {
    public static void main(String[] args) {
        int arr[] = {1,3,2,1,4,1,3,2,1,1,2};
        int k=8;
        System.out.println(findPlots(arr,k));
    }

    private static int findPlots(int[] arr, int k) {
        // start of window
        int start = 0;
        //end of window
        int end = 0;
        int count = 0;
        while(end < arr.length)
        {
            int windowSum = getWindowSum(arr,start,end);
            // window sum is less so increase window
            if(windowSum < k)
            {
                end++;
            }
            // window sum is more so increase window
            else if(windowSum > k)
            {
                start++;
            }
            // window sum is equal
            else
            {
                count++;
                end++;
            }
        }
        return count;
    }

    private static int getWindowSum(int[] arr, int start, int end) {
        int sum = 0;
        for(int i=start;i<=end;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }
}
