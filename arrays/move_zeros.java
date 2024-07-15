class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeroPos = 0;
        int nonZeroPos = 0;

        while ( zeroPos < n && nonZeroPos < n) {
            while ( zeroPos < n && nums[zeroPos] != 0 ) {
                zeroPos++;
            }
            while ( nonZeroPos < n && nums[nonZeroPos] == 0 ) {
                nonZeroPos++;
            }

            if ( zeroPos < n && nonZeroPos < n && zeroPos < nonZeroPos ) {
                // swap
                int temp = nums[zeroPos];
                nums[zeroPos] = nums[nonZeroPos];
                nums[nonZeroPos] = temp;

                zeroPos++;
                nonZeroPos++;
            } else if ( zeroPos > nonZeroPos ) {
                nonZeroPos++;
                while ( nonZeroPos < n && nums[nonZeroPos] == 0) {
                    nonZeroPos++;
                }
            }
        }
    }
}
