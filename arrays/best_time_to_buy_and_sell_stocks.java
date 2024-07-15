class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        int buyAt = prices[0];

        for (int i = 1; i < n; i ++) {
            if ( prices[i] < buyAt) {
                buyAt = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - buyAt);
            }
        }
        return ans;
    }
}
