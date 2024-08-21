class Solution {
    // BFS  (multisource)


    class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                }
            }
        }

        if (q.size() == 0 || q.size() == n*n) return -1;

        int[][] dirs = {{-1, 0},{0, 1},{1, 0},{0, -1}};
        int level = 0;
        while (!q.isEmpty()) {
            int size  = q.size();

            while (size-- > 0) {
                Pair curr = q.poll();

                for (int[] dir : dirs) {
                    int newRow = curr.row + dir[0];
                    int newCol = curr.col + dir[1];

                    if(newRow >= 0 && newRow < n && newCol >= 0 &&
                                    newCol < n && grid[newRow][newCol] == 0) {
                        q.add (new Pair(newRow, newCol));
                        grid[newRow][newCol] = 1;
                    }
                }
            }
            level ++;
        }

        return level-1;
    }
}
