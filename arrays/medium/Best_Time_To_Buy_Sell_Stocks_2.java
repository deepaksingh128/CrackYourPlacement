class Solution {
    // Logic:- buy at local minima , sell at local maxima (repeat it if possible)
    // t.c. => O(n)  , s.c.=> O(1)
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int i = 0;
        int buyAt = -1;
        int sellAt = -1;
        int maxProfit = 0;

        while (i < n) {
            while ( (i+1) < n && prices[i] > prices[i+1] ) {
                i++;
            }
            buyAt = i;
            i++;
             
            while ( (i+1) < n && prices[i] < prices[i+1] ) {
                i++;
            }
            sellAt = i;
            
            if (buyAt < (n-1) && sellAt < n) {
                maxProfit = maxProfit + prices[sellAt] - prices[buyAt];
            }
        }

        return maxProfit;
    }
}
