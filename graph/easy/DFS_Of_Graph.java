class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        
        dfs (0, ans, visited, adj);
        return ans;
    }
    
    public void dfs(int src, ArrayList<Integer> ans, boolean[] vis, 
                        ArrayList<ArrayList<Integer>> adj) {
                            
        vis[src] = true;
        ans.add(src);
        
        for (int child: adj.get(src)) {
            if (vis[child] == false) {
                dfs (child, ans, vis, adj);
            }
        }
    }
}
