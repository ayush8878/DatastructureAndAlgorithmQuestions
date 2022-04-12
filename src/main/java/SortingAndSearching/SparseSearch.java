package SortingAndSearching;

public class SparseSearch
{
    public static void main(String args[])
    {
        String[] arr = {"ai","","","","bat","","","car","cat","","","dog",""};
        String key = "bat";
        int index = searchKey(arr,key);
        System.out.print(index);
    }

    private static int searchKey(String[] arr, String key) {
        int start = 0;
        int end = arr.length-1;
        while(end>=start) {
            // find mid
            int mid = (start + end) / 2;
            if (arr[mid] == "")
            {
                mid = findMid(arr, mid);
            }
            if (key.compareTo(arr[mid]) == 0)
            {
                return mid;
            } else if (key.compareTo(arr[mid]) > 0)
            {
                start = mid;
            } else
            {
                end = mid;
            }
        }
        return -1;
    }

    private static int findMid(String[] arr, int mid) {
        while(arr[mid] == "")
        {
            int left = mid - 1;
            int right = mid + 1;
            if (arr[left] == "" && arr[right] == "") {
                left--;
                right++;
            }
            else {
                mid = arr[left] != "" ? left : right;
                break;
            }
        }
        return mid;
    }
}
