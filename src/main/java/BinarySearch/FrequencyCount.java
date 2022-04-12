package BinarySearch;

public class FrequencyCount
{
    public static void main(String args[])
    {
        int[] arr={0,1,1,2,3,3,3,3,4,5,5,5,10};
        int key = 3;
        int lb=findLowerBound(arr,key);
        int ub=findUpperBound(arr,key);
        System.out.println("Lower Bound is: "+lb);
        System.out.println("Upper Bound is: "+ub);
        System.out.println("Frequency: "+ (ub-lb));
    }

    private static int findLowerBound(int[] arr,int key) {
        int start = 0;
        int end=arr.length-1;
        int res = -1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==key)
            {
                res=mid;
                end=mid-1;
            }
            else if(arr[mid]>key)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return res;
    }

    private static int findUpperBound(int[] arr,int key) {
        int start = 0;
        int end=arr.length-1;
        int res = -1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==key)
            {
                res=mid;
                start=mid+1;
            }
            else if(arr[mid]>key)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return res;
    }

}
