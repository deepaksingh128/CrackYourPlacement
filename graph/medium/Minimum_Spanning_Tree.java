class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer (new int[]{0, 0});
        
        boolean[] inMST = new boolean[V];
        int minSum = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int vertex = curr[0];
            int weight = curr[1];
            
            if (inMST[vertex] == true) continue;
            
            inMST[vertex] = true;
            minSum += weight;
            
            for (int[] neighbour: adj.get(vertex)) {
                int adjVertex = neighbour[0];
                int adjWeight = neighbour[1];
                
                if (!inMST[adjVertex]) {
                    pq.offer (new int[]{adjVertex, adjWeight});
                }
            }
        }
        
        return minSum;
    }
}
