class Solution
{
    //Function to return list containing vertices in Topological order. 
    // Method 2:- Using BFS (Kahn's algorithm)
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] inDegree = new int[V];
        for (int u=0; u<adj.size(); u++) {
            for (int v: adj.get(u)) {
                inDegree[v] ++;
            }
        }
        
        int[] ans = new int[V];
        bfs(adj, ans, inDegree);
        
        return ans;
    }
    
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int[] ans, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            ans[idx++] = u;
            
            for (int v: adj.get(u)) {
                inDegree[v] --;
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }
    }
}
