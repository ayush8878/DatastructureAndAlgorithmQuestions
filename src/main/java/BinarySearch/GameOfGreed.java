package BinarySearch;

public class GameOfGreed {
    public static void main(String args[])
    {
        int arr[] = {1,2,3,4};
        int k=3;

        int max = kPartition(arr,k);
        System.out.print(max);
    }

    private static int kPartition(int[] arr, int k) {
        int start=0;
        int end =0;
        int res=0;
        for(int a:arr)
        {
            end+=a;
        }
        while(start<=end)
        {
            int mid=(start+end)/2;
            boolean isPossible=divideAmongK(arr,k,mid);
            if(isPossible)
            {
                start=mid+1;
                res=mid;
            }
            else
            {
                end=mid-1;
            }
        }
        return res;
    }

    private static boolean divideAmongK(int[] arr, int k, int minCoins) {
        int partitions=0;
        int currentFriend=0;

        for(int i=0;i<arr.length;i++)
        {
            if(currentFriend + arr[i] >= minCoins)
            {
                partitions+=1;
                currentFriend=0;
            }
            else
            {
                currentFriend+=arr[i];
            }
        }
        return partitions >=k;
    }
}
