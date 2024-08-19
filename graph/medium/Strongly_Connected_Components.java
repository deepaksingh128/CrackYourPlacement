class Solution {
    // Function to find the number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        
        // Step 1: Perform DFS and push finished vertices into the stack
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }
        
        // Step 2: Create a transpose of the graph
        ArrayList<ArrayList<Integer>> transpose = transposeGraph(V, adj);
        
        // Step 3: Process all vertices in the order defined by the stack
        Arrays.fill(visited, false);
        int sccCount = 0;
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                // Perform DFS on the transposed graph
                reverseDfs(node, transpose, visited);
                sccCount++;
            }
        }
        
        return sccCount;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }
        // Push the node to the stack after finishing its DFS
        stack.push(node);
    }
    
    private ArrayList<ArrayList<Integer>> transposeGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                transpose.get(neighbor).add(i);
            }
        }
        
        return transpose;
    }
    
    private void reverseDfs(int node, ArrayList<ArrayList<Integer>> transpose, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : transpose.get(node)) {
            if (!visited[neighbor]) {
                reverseDfs(neighbor, transpose, visited);
            }
        }
    }
}
