class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxProduct = Integer.MIN_VALUE;

        maxProduct = Math.max (maxProduct, nums[n-1] * nums[0] * nums[1]);
        maxProduct = Math.max (maxProduct, nums[n-1] * nums[n-2] * nums[n-3]);
        maxProduct = Math.max (maxProduct, nums[0] * nums[1] * nums[n-1]);

        return maxProduct;
    }
}
