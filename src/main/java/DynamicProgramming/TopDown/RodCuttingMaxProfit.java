package DynamicProgramming.TopDown;

import java.util.Arrays;

public class RodCuttingMaxProfit {
    public static void main(String[] args) {
        int []prices = new int[]{1,5,8,9,10,17,17,20};
        int []memo = new int[prices.length];
        System.out.println("Recursion : "+ findMaxProfit(prices,prices.length));
        System.out.println("Top Down Dp :"+findMaxProfitTopDown(prices,prices.length,memo));
        System.out.println("Bottom Up Dp :"+findMaxProfitBottomUp(prices));
    }

    private static int findMaxProfit(int[] prices,int n) {
        if(n <= 0) return 0;
        int profit = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++)
        {
            int cut = i + 1;
            int currentProfit = prices[i] + findMaxProfit(prices,n-cut);
            profit = Math.max(currentProfit,profit);
        }
        return profit;
    }

    private static int findMaxProfitTopDown(int[] prices,int n,int memo[]) {
        if(n <= 0) return 0;
        int profit = Integer.MIN_VALUE;
        int loopCount =0;
        for(int i = 0;i<n;i++)
        {
            int cut = i + 1;
            int currentProfit = memo[i] !=0 ? memo[i] :prices[i] + findMaxProfit(prices,n-cut);
            profit = Math.max(currentProfit,profit);
            memo[i] = profit;
        }
        return profit;
    }

    /**
     * This method will calculate max profit  using bottom up approach
     * @param prices
     * @return
     */
    private static int findMaxProfitBottomUp(int[] prices) {
        int []memo = new int[prices.length+1];
        memo[0] = 0;
        // For each len of rod which will be 1,2,3,4,5,6,7,8
        for (int rodLen = 1; rodLen <= prices.length; rodLen++) {
            // consider max profit as int min
            int maxProfit = Integer.MIN_VALUE;
            // now try to split above rod in small parts where j represent the 1st part and cut rep the cut which will help identify memo[rodLen - cut]
            // for rodLen = 8 j will start from 0 and iterate till 7 , and provide max profit for each choice
            // for rodLen = 8 , j = 0  cut = 1 , currentProfit = 1 + memo[8 - 1] = 1 + memo[7]
            for (int j = 0; j < rodLen; j++) {
                int cut = j+1;
                int currentProfit = prices[j]+ memo[rodLen - cut];
                maxProfit = Math.max(currentProfit,maxProfit);
            }
            memo[rodLen] = maxProfit;
        }
        return memo[prices.length];
    }
}
