package DynamicProgramming.TopDown;

public class NLadderProblem {

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        int[] memo = new int[n+1];
        memo[0] = 0;
        int paths = findPaths(n,k,memo);
        System.out.println(paths);
    }

    /**
     * O(n*k)
     * @param n
     * @param k
     * @param memo
     * @return
     */
    private static int findPaths(int n,int k,int[] memo) {
        // edge condition
        if(n < 0)
        {
            return 0;
        }
        // base condition
        if(n == 0)
        {
            return 1;
        }
        // if already present in memory then reuse it only
        if (memo[n] != 0)
        {
            return memo[n];
        }
        int count = 0;
        // Check for each step and evaluate count
        for(int jump = 1;jump<=k;jump++)
        {
            count += findPaths(n - jump, k, memo);
        }
        memo[n] = count;
        return memo[n];
    }
}
