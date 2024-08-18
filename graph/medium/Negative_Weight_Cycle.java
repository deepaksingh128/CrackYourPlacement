class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] distance = new int[n];
        
        // Run Bellman-Ford from each node to ensure all components are checked
        for (int start = 0; start < n; start++) {
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[start] = 0;
            
            // Relax all edges (n-1) times
            for (int i = 1; i <= n - 1; i++) {
                for (int[] edge : edges) {
                    int u = edge[0];
                    int v = edge[1];
                    int wt = edge[2];
                    
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                        distance[v] = distance[u] + wt;
                    }
                }
            }
            
            // Check for a negative-weight cycle
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                
                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    return 1; // Negative weight cycle detected
                }
            }
        }
        
        return 0;
    }
}
