class Solution {
    // Approach 1 : Recursion + Memoizatin

    int MOD = (int)1e9+7;
    List<List<Integer>> adj = new ArrayList<>();

    private int solve (int n, int cell, int[][] dp) {
        if (n == 0) {
            return 1;
        }

        if (dp[n][cell] != -1) {
            return dp[n][cell];
        }

        int ans = 0;
        for (int nextCell: adj.get(cell)) {
            ans = (ans + solve (n-1, nextCell, dp)) % MOD;
        }

        return dp[n][cell] = ans;
    }

    public int knightDialer(int n) {
        adj.add(Arrays.asList(4, 6));    
        adj.add(Arrays.asList(6, 8)); 
        adj.add(Arrays.asList(7, 9));   
        adj.add(Arrays.asList(4, 8));   
        adj.add(Arrays.asList(3, 9, 0)); 
        adj.add(new ArrayList<>());      
        adj.add(Arrays.asList(1, 7, 0)); 
        adj.add(Arrays.asList(2, 6));    
        adj.add(Arrays.asList(1, 3));    
        adj.add(Arrays.asList(2, 4));

        int result = 0;
        int[][] dp = new int[n+1][10];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        for (int cell = 0; cell <= 9; cell++) {
            result = (result + solve (n-1, cell, dp)) % MOD;
        }

        return result;
    }
}


// Approach 2 : Bottom Up (Tabulation)

class Solution {

    int MOD = (int)1e9+7;
    List<List<Integer>> adj = new ArrayList<>();

    public int knightDialer(int n) {
        adj.add(Arrays.asList(4, 6));    
        adj.add(Arrays.asList(6, 8)); 
        adj.add(Arrays.asList(7, 9));   
        adj.add(Arrays.asList(4, 8));   
        adj.add(Arrays.asList(3, 9, 0)); 
        adj.add(new ArrayList<>());      
        adj.add(Arrays.asList(1, 7, 0)); 
        adj.add(Arrays.asList(2, 6));    
        adj.add(Arrays.asList(1, 3));    
        adj.add(Arrays.asList(2, 4));

        int result = 0;
        int[][] dp = new int[n][10];
        // Base case :-
        for (int cell=0; cell <=9; cell++) {
            dp[0][cell] = 1;
        }

        for (int i=1; i<=n-1; i ++) {

            for (int cell=0; cell<=9; cell++) {

                int ans = 0;
                for (int nextCell: adj.get(cell)) {
                    ans = (ans + dp[i-1][nextCell]) % MOD;
                }
                dp[i][cell] = ans;
            }
        }

        for (int cell=0; cell<=9; cell++) {
            result = (result + dp[n-1][cell]) % MOD;
        }


        return result;
    }
}
