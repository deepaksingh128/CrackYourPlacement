class Solution {
    // In single pass: - Using Dutch flag algorithm
    public void sortColors(int[] nums) {
        int n =  nums.length;

        int i = 0;        // 0s till i-1
        int j = 0;         // 1s  from i to j-1
                           // j to k => still need to process
        int k = n-1;       // 2s from k+1 To end


        while (j <= k) {
            if (nums[j] == 0) {
                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++; 
            } else if (nums[j] == 1) {
                j++;
            } else {
                // swap
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            }
        }
    }
}
