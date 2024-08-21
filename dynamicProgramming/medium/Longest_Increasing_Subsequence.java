class Solution {
    // Method 1 :- (Recursion + Memoization)

    private int solve (int[] nums, int i, int prev, int[][] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (prev != -1 && dp[i][prev] != -1) {
            return dp[i][prev];
        }

        int take = 0;
        if (prev == -1 || nums[prev] < nums[i]) {
            take = 1 + solve (nums, i+1, i, dp);
        }

        int skip = solve (nums, i+1, prev, dp);

        if (prev != -1) {
            dp[i][prev] = Math.max (take, skip);  // memoize only when
        }                                        // prev is not -1

        return Math.max (take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for (int[] r: dp) {
            Arrays.fill(r, -1);
        }

        return solve (nums, 0, -1, dp);
    }
}
