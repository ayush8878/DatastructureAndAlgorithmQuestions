package DynamicProgramming.BottomUp;

public class NLadderProblem {
    public static void main(String[] args) {
        int n = 3;
        int k = 3;

        //int paths = findPaths(n,k);
        int paths = findPathsUsingSlidingWindowMath(n,k);
        System.out.println(paths);
    }

    /**
     * O (n * k)
     * @param n
     * @param k
     * @return
     */
    private static int findPaths(int n, int k) {
        int[] memo = new int[n+1];
        // initialize memory
        memo[0] = 1;
        // from the first index till the end look for paths depending on the previous paths
        for (int i=1;i<n+1;i++)
        {
            int paths = 0;
            // check for the bottom jumps based on k and make sure its greater than 0
            for(int jump = 0;jump<=k && i-jump>=0;jump++)
            {
                paths+=memo[i-jump];
            }
            memo[i] = paths;
        }
        return memo[n];
    }

    /**
     * O (n)
     * @param n
     * @param k
     * @return
     */
    private static int findPathsUsingSlidingWindow(int n, int k) {
        int[] memo = new int[n+1];
        // initialize memory
        memo[0] = 1;
        // from the first index till the end look for paths depending on the previous paths
        int windowStart = 0;
        int windowEnd = 0;
        int windowSum = 0;
        for (int i=1;i<n+1;i++)
        {
            // add prev window end to window sum
            windowSum+=memo[windowEnd];
            // increment windowEnd
            windowEnd++;
            // if there is a scenario where window size has been increased then remove the out of window data
            if(windowStart + windowEnd > k)
            {
                windowSum-=memo[windowStart];
                windowStart++;
            }
            // update current window end with the window sum
            memo[windowEnd] = windowSum;
        }
        return memo[n];
    }


    /**
     * O (n+k)
     * @param n
     * @param k
     * @return
     */
    private static int findPathsUsingSlidingWindowMath(int n, int k) {
        int[] memo = new int[n+1];
        // initialize memory
        memo[0] = 1;
        memo[1] =1;
        // from the first index till the end look for paths depending on the previous paths

        for (int i=2;i<=k;i++)
        {
           memo[i] = 2 * memo[i-1];
        }
        for(int i = k+1; i<=n;i++)
        {
            memo[i] = 2 * memo[i-1] - memo[i-k-1];
        }
        return memo[n];
    }
}
