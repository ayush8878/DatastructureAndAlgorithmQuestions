package DynamicProgramming.TopDown;

import java.util.Arrays;

public class FrogMinCost {
    public static void main(String[] args) {
      //  int[] stones = new int[]{10,30,40,20};
        int[] stones = new int[]{30,10,60,10,60,50};
        int n = 6;
        System.out.println(findMinCost(stones));
    }

    private static int findMinCost(int[] stones) {
        int n = stones.length;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = Math.abs(stones[1] - stones[0]);

        for(int i = 2;i<stones.length;i++)
        {
            int firstJump = memo[i-1] + Math.abs(stones[i] - stones[i-1]);
            int secondJump = memo[i-2] + Math.abs(stones[i] - stones[i-2]);
            memo[i] = Math.min(firstJump,secondJump);
        }
        System.out.println(Arrays.toString(memo));
        // returning memo[n-1] as there are total n stones
        return memo[n-1];
    }
}
