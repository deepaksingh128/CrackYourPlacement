class Solution {
    // Mathod 1 :-  Detect cycle (Using BFS (kahn's algorithm), topological sort)

    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        int[] indegree = new int[N];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0; i<N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<P; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            
            adj.get(u).add(v);
            indegree[v] ++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count ++;
            
            for (int v: adj.get(u)) {
                indegree[v] --;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        
        return count == N;
    }
    
}
