class Solution {
    // t.c. => O(n)  , s.c.=> O(1)
    List<Integer> ans = new ArrayList<>();

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;

            if (nums[idx] < 0) {
                ans.add(idx + 1);
            }
            nums[idx] = -nums[idx];
        }

        return ans;
    }
}
