package BinarySearch;

/*
What a Code Ayush , good job
*/
public class RotatedSearch {

    public static void main(String args[])
    {
        int[] arr={7,9,10,1,2,3,4,5,6};
        int key=4;
        int index = rotatedSearchOptimal(arr,key);
        System.out.print(index);
    }

    private static int rotatedSearchOptimal(int[] arr, int key) {
        int start = 0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==key)
            {
                return mid;
            }
            // other 2 cases

            if(arr[start]<=arr[mid])
            {
                //left
                if(key>arr[start] && key<=arr[mid])
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
            else
            {
                if(key>=arr[mid] && key<=arr[end])
                {
                    start=mid+1;
                }
                else
                {
                    end=mid-1;
                }
            }
        }
        return -1;
    }

    private static int rotatedSearch(int[] arr, int key) {
        // find start
        int start = 0;
        int end = arr.length-1;
        while(start<=end)
        {
            int mid = (start+end)/2+1;
            if(arr[mid-1]>arr[mid])
            {
                start = mid;
                break;
            }
            else if(arr[mid-1]<arr[mid])
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        // updating actual end
        if(key>arr[arr.length-1])
        {
            end=start-1;
            start=0;
        }
        else
        {
            end=arr.length-1;
        }
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(arr[mid] == key)
            {
                return mid;
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
        return -1;
    }
}
