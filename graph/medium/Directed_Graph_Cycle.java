class Solution {
    // Function to detect cycle in a directed graph.
    // Method 2:- Using BFS (Kahn's algorithm)
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int u=0; u<adj.size(); u++) {
            for (int v: adj.get(u)) {
                inDegree[v] ++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i=0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                count ++;
            }
        }
        
        while (!q.isEmpty()) {
            int u = q.poll();
            
            for (int v: adj.get(u)) {
                inDegree[v] --;
                if (inDegree[v] == 0) {
                    q.add(v);
                    count ++;
                }
            }
        }
        
        if (count == V) {
            return false;
        } else {
            return true;
        }
    }
}
