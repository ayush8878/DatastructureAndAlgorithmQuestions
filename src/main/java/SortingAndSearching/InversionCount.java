package SortingAndSearching;

public class InversionCount {

    public static void main(String args[])
    {
        int[] arr={0,5,2,3,1};
        int count = findInversionCount(arr);
        System.out.println(count);
    }

    private static int findInversionCount(int[] arr) {
        // sort from start to end
        return findInversionCount(arr,0,arr.length-1);
    }

    private static int findInversionCount(int[] arr, int start, int end)
    {
        // if 1 element only
        if(end - start == 0)
        {
            return 0;
        }
        // for 2 element
        else if(end - start == 1)
        {
            // if start is less then no need to swap
            if(arr[start] < arr[end])
            {
                return 0;
            }
            // swap
            else
            {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start]=temp;
                return 1;
            }
        }
        else
        {
            int mid = (start+end)/2;
            // left inversions
            int leftCount = findInversionCount(arr,start,mid);
            // right inversions
            int rightCount = findInversionCount(arr,mid+1,end);
            // cross inversion
            int overlap = merge(arr,start,mid,end);
            return leftCount + rightCount + overlap;
        }
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int count = 0;
        int i =start;
        int j=mid+1;
        // temp array
        int[] temp=new int[end-start+1];
        // counter
        int tempC = 0;
        // while both sub-array are not traversed
        while(i<=mid && j<=end)
        {
            if(arr[i] < arr[j])
            {
               temp[tempC] = arr[i];
                i++;
            }
            else if(arr[i] > arr[j])
            {
                temp[tempC] = arr[j];
                j++;
                // inversions will be possible for all elements after i
                count+=mid-i+1;
            }
            tempC++;
        }
        while(i<=mid)
        {
            temp[tempC] = arr[i];
            i++;
            tempC++;
        }
        while(j<=end)
        {
            temp[tempC] = arr[j];
            j++;
            tempC++;
        }
        for(int k=0;k<temp.length;k++)
        {
            arr[start]=temp[k];
            start++;
        }
        return count;
    }
}
