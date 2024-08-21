

class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        
        int[] colors = new int[n];
        
        return graphColoringHelper (graph, m, n, 0, colors);
    }
    
    public boolean isSafe (boolean[][] graph, int vertex, int color, int[] colors) {
        
        for (int adjacent=0; adjacent<graph.length; adjacent++) {
            if (graph[vertex][adjacent] && color == colors[adjacent]) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean graphColoringHelper (boolean[][] graph, int m, int n, int vertex, int[] colors) {
        
        if (vertex == n) {
            return true;
        }
        
        
        for (int color=1; color<=m; color++) {
            
            if (isSafe(graph, vertex, color, colors)) {
                colors[vertex] = color;
                
                if (graphColoringHelper(graph, m, n, vertex + 1, colors)) {
                    return true;
                }
                
                colors[vertex] = 0;  // backtrack
            }
        }
        
        return false;
    }
}
