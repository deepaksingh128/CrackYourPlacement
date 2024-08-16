class Solution {
    // DFS + BFS
    
    class Coordinates {
        int x, y;
        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void dfs (int[][] grid, int i, int j, Queue<Coordinates> q, boolean[][] vis, int[][] dir) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || vis[i][j] == true || grid[i][j] == 0) {
            return;
        }

        vis[i][j] = true;
        q.offer (new Coordinates(i, j));

        for (int[] curr: dir) {
            dfs (grid, i + curr[0], j + curr[1] , q, vis, dir);
        }
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<Coordinates> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean flag = false;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q, vis, dir);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            while (size -- > 0) {
                Coordinates curr = q.poll();
                
                for (int k=0; k<4; k++) {
                    int newX = curr.x + dir[k][0];
                    int newY = curr.y + dir[k][1];

                    if (newX >= 0 && newX < n && newY >= 0 && 
                            newY < n && vis[newX][newY] == false) {
                        if (grid[newX][newY] == 1) {
                            return steps;
                        }
                        q.offer(new Coordinates(newX, newY));
                        vis[newX][newY] = true;
                    }
                }
            }
            steps ++;
        }

        return -1;
    }
}
