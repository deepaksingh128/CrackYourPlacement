class Solution {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private boolean isSafe (int r, int c, int n, int m) {
        return (r >= 0 && r < n && c >= 0 && c < m);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origColor = image[sr][sc];

        if (origColor == color) return image;

        int n = image.length;
        int m = image[0].length;

        Queue<Pair> q = new LinkedList<>();
        image[sr][sc] = color;
        q.add(new Pair(sr, sc));

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            int r = curr.first;
            int c = curr.second;

            int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

            for (int k=0; k<4; k++) {
                int newR = r + dir[k][0];
                int newC = c + dir[k][1];

                if (isSafe(newR, newC, n, m) && image[newR][newC] == origColor) {
                    image[newR][newC] = color;
                    q.add (new Pair(newR, newC));
                }
            }
        }

        return image;
    }
}
