package Recursion;

public class Ladder {

    public static void main(String[] args) {
        int totalWays= totalWays(4);
        System.out.println("Total ways are "+totalWays);

    }

    static int totalWays(int n)
    {
        // base case
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        // recursive case
        int x = totalWays(n-1);
        int y = totalWays(n-2);
        int z= totalWays(n-3);
        return x+y+z;
    }
}
