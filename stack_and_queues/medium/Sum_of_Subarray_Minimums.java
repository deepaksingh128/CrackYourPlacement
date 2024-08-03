class Solution {

    // helper function Next Smaller Left
    public int[] getNSL(int[] arr) {
        ArrayDeque<Integer> st = new ArrayDeque<>();

        int[] ans = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            while (!st.isEmpty()  && arr[st.peek()] >= arr[i]) { // place
                                           // equal at one of these helper functions to avoid duplicates
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[i] = st.peek();
            } else {
                ans[i] = -1;
            }
            st.push(i);
        }

       return ans;
    }

    // helper funtion Next Smaller Right
    public int[] getNSR(int[] arr) {
        int n = arr.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();

        int[] ans = new int[n];

        for (int i=n-1; i>=0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek();
            } else {
                ans[i] = n;
            }
            st.push(i);
        }
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] nsl = getNSL(arr);
        int[] nsr = getNSR(arr);

        long totalSum = 0;
        int M = (int)1e9+7;

        for (int i=0; i<arr.length; i++) {
            int smallerInLeft = i - nsl[i];
            int smallerInRight = nsr[i] - i;

            long noOfSubarrays = (long) smallerInLeft * smallerInRight; // no of subarrays in 
                                                            // in which arr[i] is minimum
            long sum = (long) noOfSubarrays * arr[i];           

            totalSum = (totalSum + sum) % M;
        }

        return (int) totalSum;
    }
}
