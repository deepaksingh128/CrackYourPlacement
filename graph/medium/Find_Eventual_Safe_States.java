class Solution {

    // Method 1 : DFS
    
    public boolean isCycleDFS(int[][] graph,int i,boolean[] vis,boolean[] inRecursion){
        vis[i] = true;
        inRecursion[i] = true;

        for (int v: graph[i]) {
            if (vis[v] == false && isCycleDFS(graph, v, vis, inRecursion)) {
                return true;
            } else if (inRecursion[v] == true) {
                return true;
            }
        }

        inRecursion[i] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] inRecursion = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!vis[i]) {
                isCycleDFS(graph, i, vis, inRecursion);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i=0; i<inRecursion.length; i++) {
            if (inRecursion[i] == false) {
                ans.add(i);
            }
        }

        return ans;
    }
}
