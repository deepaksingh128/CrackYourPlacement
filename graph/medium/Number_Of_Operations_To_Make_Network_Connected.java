class Solution {
    int[] parent;
    int[] rank;

    int find (int i) {
        if (parent[i] == i) {
            return i;
        }  return parent[i] = find(parent[i]);
    }

    void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return;
        }

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[yParent] > rank[xParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent] ++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        
        parent = new int[n];
        rank = new int[n];

        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int components = n;
        for (int[] arr: connections) {
            if (find(arr[0]) != find(arr[1])) {
                union (arr[0], arr[1]);
                components --;
            }
        }

        return components - 1;
    }
}
