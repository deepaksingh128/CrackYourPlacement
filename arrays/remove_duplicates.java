class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int count = 1;

        int currPos = 0;
        int nextNoPos = 1;

        while (nextNoPos < nums.length) {
            if ( nums[nextNoPos] != nums[currPos] ) {
                currPos++;
                count++;
                nums[currPos] = nums[nextNoPos];
                nextNoPos++;
            } else {
                nextNoPos++;
            }
        } 
        return count;
    }
}
