class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int [] ngr = nextGreaterRight(nums2);

        for (int i=0; i<ngr.length; i++) {
            map.put (nums2[i], ngr[i]);
        }

        int[] ans = new int[nums1.length];

        for (int i=0; i<ans.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public int[] nextGreaterRight (int[] nums) {
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i --) {
            while (st.size() > 0 && st.peek() < nums[i]) {
                st.pop();
            }
            ans[i] = st.size() > 0 ? st.peek() : -1;
            st.push(nums[i]);
        }

        return ans;
    }
}
