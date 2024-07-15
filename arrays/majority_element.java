class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int current = 0;
        int count = 0;

        for (int i = 0; i < n; i ++) {
            if (count == 0) {
                current = nums[i];
                count++;
            } else if ( i > 0 && nums[i] == current ) {
                count++;
            } else {
                count--;
            }
        }

        return current;
    }
}
