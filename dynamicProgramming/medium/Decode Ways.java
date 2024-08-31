 // Approach 1 :- Recursion + Memoization

class Solution {
    
    private int solve (String s, int idx, int n, int[] dp) {
        if (dp[idx] != -1) {
            return dp[idx];
        }

        if (idx == n) {
            return dp[idx] = 1;
        }

        if (s.charAt(idx) == '0') {
            return dp[idx] = 0;
        }

        int result = solve (s, idx + 1, n, dp);

        if (idx + 1 < n) {
            if(s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx+1) <= '6') {
                result += solve (s, idx + 2, n, dp);
            }
        }

        return dp[idx] = result;
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[101];
        Arrays.fill(dp, -1);

        return solve (s, 0, n, dp);
    }
}
