class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int preSum = 0;

        for (int i = 0; i < nums.length; i ++) {
            preSum += nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        int lo = max;
        int hi = preSum;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (noOfSubarraysWithThisSum(nums, mid) <= k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int noOfSubarraysWithThisSum(int[] nums, int mid) {
        int noOfSubarrays = 1;
        int sum = 0;

        for (int i=0; i<nums.length; i++) {
            if (sum + nums[i] > mid) {
                noOfSubarrays ++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }

        return noOfSubarrays;
    }
}
