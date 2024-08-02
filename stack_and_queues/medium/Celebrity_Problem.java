class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;
        Stack<Integer> st = new Stack<>();
        
        for (int i=0; i<n; i++) {
            st.push(i);
        }
        
        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();
            
            if (mat[i][j] == 1) {
                st.push(j);            // since , i cannot be the celebrity
            } else {
                st.push(i);        // since , j cannot be the celebrity
            }
        }
        
        int potentialCandidate = st.pop();
        
        // now check that row and col
        for (int i=0; i<mat.length; i++) {
            if (i != potentialCandidate) {
                if (mat[i][potentialCandidate] == 0 || mat[potentialCandidate][i] == 1) {
                    return -1;
                }
            }
        }
        
        return potentialCandidate;
    }
}
