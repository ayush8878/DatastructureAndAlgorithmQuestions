package BinarySearch;

public class SquareRoot {
    public static void main(String args[])
    {
        int no=10;
        int p=3;
        double sqrt = findSqrt(no,p);
        System.out.print(sqrt);
    }

    private static double findSqrt(int no, int p) {
        int start =0;
        int end=no;
        int mid = -1;
        float res = -1;
        while(start<end)
        {
            mid=(start+end)/2;
            // found exact match
            if(mid*mid == no)
            {
                return mid;
            }
            else if(mid*mid > no)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        res+=mid;
        // float increment
        float inc=0.1f;
        // loop for upto decimal
        for(int place=0;place<p;place++)
        {
            //do linear search
            while(res*res <= no)
            {
                // add to result the increment
                res+=inc;
            }
            // take one step back
            // by the time this loop will break res will get incremented to 1 higher value
            res=res-inc;
            // moving to next decimal place
            inc=inc/10.0f;
        }
        return res;
    }
}
