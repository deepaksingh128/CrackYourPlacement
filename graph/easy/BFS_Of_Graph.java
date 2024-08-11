class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        
        q.add(0);
        visited[0] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add (curr);
            
            for (int child: adj.get(curr)) {
                if (visited[child] == false) {
                    q.add(child);
                    visited[child] = true;;
                }
            }
        }
        
        return ans;
    }
}
