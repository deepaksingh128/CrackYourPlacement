class Solution {
    // Using stack:- t.c. => O(n)  , s.c.=> O(n)
    
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[n];

        for (int i=n-1; i>=0; i--) {
            int currTemp = temperatures[i];
            while (!st.isEmpty() && temperatures[st.peek()] <= currTemp) {
                st.pop();
            } 
            if (!st.isEmpty()) {
                ans[i] = st.peek() - i;
            } else {
                ans[i] = 0;
            }

            st.push(i);
        }

        return ans;
    }
}
