class Solution {

    public int[] nextSmallerRight(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] nextSmallerLeft(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int maximumAreaHelper(int[] heights) {
        int[] nsr = nextSmallerRight(heights);
        int[] nsl = nextSmallerLeft(heights);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int currRectangleMaxArea = height * width;
            maxArea = Math.max(maxArea, currRectangleMaxArea);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];

        // Initialize heights from the first row
        for (int i = 0; i < m; i++) {
            heights[i] = matrix[0][i] == '1' ? 1 : 0;
        }

        int maxArea = maximumAreaHelper(heights);

        // Update heights row by row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            maxArea = Math.max(maxArea, maximumAreaHelper(heights));
        }

        return maxArea;
    }
}
