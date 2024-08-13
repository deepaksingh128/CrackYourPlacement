class Solution
{
    // Method 2 :- Using BFS
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for (int i=0; i<V; i++) {
            if (color[i] == -1) {
                if (isBipartiteBFS(adj, i, color, 1) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isBipartiteBFS(ArrayList<ArrayList<Integer>> adj, int curr, int[] color, int currColor) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);
        color[curr] = currColor;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int v: adj.get(u)) {
                if (color[v] == color[u]) {
                    return false;
                }
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                }
            }
        }
        
        return true;
    }
}
