package DynamicProgramming.TopDown;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1,3,7,10};
        int money = 18;
        int[] pos = new int[money+1];
        System.out.println("Using Recursion :"+findMinimumCoinsForMoney(money,coins));
        System.out.println("Using Top Down Dp :"+findMinimumCoinsForMoneyTopDown(money,coins,pos));
        System.out.println("Using Bottom Up Dp :"+findMinimumCoinsForMoneyBottomUp(money,coins,pos));
    }

    /**
     * This method will recursively check for min coins
     * @param money
     * @param coins
     * @return
     */
    private static int findMinimumCoinsForMoney(int money, int[] coins) {
        // base case
        if(money == 0)
        {
            return 0;
        }
        // for each sub-sum of money no of coins required
        int minCoins = 0;
        // recursively check for each coin
        for(int i=0;i<coins.length;i++)
        {
            // if money - coin >= 0 then only proceed
            // 3 - 7 >= 0 which is false so need to check for this
            if(money-coins[i] >= 0) {
                // recursively check for remaining money
                int requiredCoins = findMinimumCoinsForMoney(money - coins[i], coins);
                // consider min among all coins and store min coins + 1
                minCoins = Math.min(minCoins, requiredCoins) + 1;
            }
        }
        return minCoins;
    }

    /**
     * This method will use DP to find minimum coins using top-down approach
     * @param money
     * @param coins
     * @param pos
     * @return
     */
    private static int findMinimumCoinsForMoneyTopDown(int money, int[] coins,int[] pos) {
        // base case
        if(money == 0)
        {
            return 0;
        }
        // for each sub-sum of money no of coins required
        int minCoins = 0;
        // recursively check for each coin
        for(int i=0;i<coins.length;i++)
        {
            // if money - coin >= 0 then only proceed
            // 3 - 7 >= 0 which is false so need to check for this
            if(money-coins[i] >= 0) {
                // check if coins for remaining money is already identified or not and dont call recursion if found
                int requiredCoins = (pos[money-coins[i]] != 0) ?pos[money-coins[i]]:findMinimumCoinsForMoney(money - coins[i], coins);
                // put required coins in pos money-coins[i]
                // this will be 15 - 1 == 14
                pos[money-coins[i]] = requiredCoins;
                // consider min among all coins and store min coins + 1
                minCoins = Math.min(minCoins, requiredCoins) + 1;
            }
        }
        return minCoins;
    }

    /**
     * This method will find minimum coins using bottom up dp
     * @param money
     * @param coins
     * @param pos
     * @return
     */
    private static int findMinimumCoinsForMoneyBottomUp(int money, int[] coins, int[] pos) {
        // initialize pos 0 and 1
        pos[0] = 0;
        pos[1] = 1;
        // for each position check for the previously solved solutions
        for(int i= 2; i < pos.length;i++)
        {
            // consider initial value as max
            int count = Integer.MAX_VALUE;
            // consider each coin and find the min possible using all coins
            for(int j = 0; j < coins.length;j++)
            {
                // don't check for solution if i - coins[j] < 0
                if(i - coins[j] >= 0)
                {
                    // Concider min among the current count and each coin at position j and
                    // pos[i - coins[j] here i is the current pos and coins[j] is the coin that need to be concidered
                    count = Math.min(pos[i - coins[j]]+1,count);
                }
            }
            // return the pos of last
            pos[i] = count;
        }
        return pos[money];
    }
}
