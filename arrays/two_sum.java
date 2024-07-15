class Solution {
    // Using HashMap
    // t.c.=> O(n), s.c.=> O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j ++) {
            int remainingTarget = target - nums[j];

            if (map.containsKey(remainingTarget) && map.get(remainingTarget) != j) {
                int[] ans = new int[] { j, map.get(remainingTarget) };
                return ans;
            }
        }

        return null;
    }
}
