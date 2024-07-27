class Solution {
    public int firstMissingPositive(int[] nums) {
        // first traversal :- Check whether 1 is present or not,
        //           Also mark the values out of [1,n] as 1
        boolean isContainsOne = false;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                isContainsOne = true;
            }
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        // if 1 is not present , return 1
        if (isContainsOne == false) {
            return 1;
        }

        // Second traversal :- Use values as index and mark negative correspondingly
        for (int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                continue;
            }
            nums[idx] *= -1;
        }

        // Third traversal :- The first element from left which remains positive 
        //                    will give the answer

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // If [1, n] are present then (n+1) is the answer

        return nums.length + 1;
    }
}
