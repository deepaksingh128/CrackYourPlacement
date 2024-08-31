// Approach :- t.c.=> O(n * m) , s.c.=> O(n)
class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int[] minNumberOfCoinsDP = new int[amount + 1];
        for (int i=1; i<=amount; i++) {
            minNumberOfCoinsDP[i] = Integer.MAX_VALUE;

            for (int coin: coins) {
                if (coin <= i && minNumberOfCoinsDP[i - coin] != Integer.MAX_VALUE) {
                    minNumberOfCoinsDP[i] = Math.min(minNumberOfCoinsDP[i],
                                                1 +  minNumberOfCoinsDP[i - coin]);
                }
            }
        }

        if (minNumberOfCoinsDP[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return minNumberOfCoinsDP[amount];
    }
}
