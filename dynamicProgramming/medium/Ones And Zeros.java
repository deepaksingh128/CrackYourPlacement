class Solution {
    // Approach 2 :- Recursion + Memoization
    //        3-D

    private int[] count0s1s(String str) {
        int n = str.length();
        int count0 = 0;
        int count1 = 0;

        for (char c : str.toCharArray()) {
            if (c == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        return new int[]{count0, count1};
    }


    private int solve(String[] strs, int m, int n, int idx, int[][][] dp) {
        if (idx == strs.length) {
            return 0;
        }

        if (dp[idx][m][n] != -1) {
            return dp[idx][m][n];
        }

        int[] count = count0s1s(strs[idx]);

        int take = 0;
        if (count[0] <= m && count[1] <= n) {
            take = 1 + solve(strs, m - count[0] , n - count[1], idx + 1, dp);
        }

        int notTake = solve (strs, m, n, idx + 1, dp);

        return dp[idx][m][n] =  Math.max (take, notTake); 
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int[][][] dp  = new int[size][m+1][n+1];
        for (int i=0; i<size; i++) {
            for (int j=0; j<=m; j++) {
                for (int k=0; k<=n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve (strs, m, n, 0, dp);
    }
}
