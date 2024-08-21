class Solution {

     private void dfs(int[][] stones, boolean[] visited, int index) {
        visited[index] = true;
        
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] && 
                (stones[i][0] == stones[index][0] || 
                stones[i][1] == stones[index][1])) {
                dfs(stones, visited, i);
            }
        }
    }


    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int numberOfComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(stones, visited, i);
                numberOfComponents++;
            }
        }

        return n - numberOfComponents;
    }
}
