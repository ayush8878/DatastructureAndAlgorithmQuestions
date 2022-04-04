package DynamicProgramming.TopDown;

public class CountingTrees {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(findMaxBSTRecursion(n));
        int memo[] = new int[n+1];
        System.out.println(findMaxBSTTopDown(n,memo));
        System.out.println(findMaxBSTBottomUp(n));
    }

    /**
     * This method will find max bst using recursion
     * @param n
     * @return
     */
    private static int findMaxBSTRecursion(int n) {
        // if in case n is 0 or 1 then max 1 bst is possible only
        if( n == 0 || n == 1)
            return 1;
        int max = 0;
        // for each node as root
        for (int i = 1; i <= n; i++) {
            // combinations for left subtree
            int x = findMaxBSTRecursion(i-1);
            // combinations for right subtree
            int y = findMaxBSTRecursion(n-i);
            // combinations for current node
            max += x*y;
        }
        return max;
    }

    /**
     * This method will find max bst using top-down approach
     * @param n
     * @param memo
     * @return
     */
    private static int findMaxBSTTopDown(int n,int memo[]) {
        if( n == 0 || n == 1)
            return 1;
        // return from memo if found
        if(memo[n] != 0)
        {
            return memo[n];
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int x = findMaxBSTRecursion(i-1);
            int y = findMaxBSTRecursion(n-i);
            max += x*y;
            memo[i] = max;
        }
        return memo[n];
    }

    /**
     * This method will find max bst using bottom up approach
     * @param N
     * @return
     */
    private static int findMaxBSTBottomUp(int N) {
        int[] memo = new int[N+1];
        memo[0] = 1;
        memo[1] =1;
        // memoization loop
        for(int n=2;n<=N;n++)
        {
            // for each node considering root
            for (int i = 1; i <= n; i++) {
                // memo[n] will be memo[i-1] * memo[n-i]
                memo[n] += memo[i-1] * memo[n-i];
            }
        }
        return memo[N];
    }
}
