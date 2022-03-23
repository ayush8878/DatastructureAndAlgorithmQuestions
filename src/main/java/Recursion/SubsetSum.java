package Recursion;

public class SubsetSum {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5};
        int sum = 6;
        int count = findSubsetSum(sum,0,arr);
        System.out.println(count);
    }

    static int findSubsetSum(int X,int i,int arr[])
    {
        // base case
        if(arr.length == i) {
            if (X == 0)
                return 1;
            else
                return 0;
        }

        // recursion call
        int inc = findSubsetSum(X-arr[i],i+1,arr);
        int exc = findSubsetSum(X,i+1,arr);
        return inc+exc;

    }
}
