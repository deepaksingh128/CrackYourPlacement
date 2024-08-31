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


// Approach 2 :- Bottom up
// t.c. => O(n), s.c.=> O(n)
class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        // dp[i] = no of ways to decode string from index i to n
        int[] dp = new int[n+1];
        dp[n] = 1;

        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i+1];

                if (i + 1 < n) {
                    if (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6') {
                        dp[i] += dp[i+2];
                    }
                }
            }
        }
        return dp[0];
    }
}
