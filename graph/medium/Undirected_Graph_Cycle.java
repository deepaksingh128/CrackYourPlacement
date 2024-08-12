class Solution {
    // Function to detect cycle in an undirected graph.
    // Method 2:- Using BFS
    
    private class Pair {
        int first;
        int second;
        
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        
        for (int i=0; i<V; i++) {
            if (!vis[i] && cycleByBfs (i, vis, adj)) {
                return true;
            }
        }
        
        return false;
    }
    
    boolean cycleByBfs(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(v, -1));       // vertex , parent
        vis[v] = true;
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int src = p.first;
            int parent = p.second;
            
            for (int child: adj.get(src)) {
                if (vis[child] == false) {
                    vis[child] = true;
                    q.add(new Pair(child, src));
                } else if (child != parent){
                    return true;
                }
            }
        }
        
        return false;
    }
}
