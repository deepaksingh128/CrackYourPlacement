class Solution {
    int count = 0;

    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = i + 1;
        }
        countArrangementHelper(nums, 0);
        return count;
    }

    public void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void countArrangementHelper (int[] nums, int index) {
        if (index == nums.length) {
            count ++;
            return;
        }

        for (int i=index; i<nums.length; i++) {

            swap(nums, index, i);
            if (nums[index] % (index+1) == 0 || (index + 1) % nums[index] == 0) {
                countArrangementHelper(nums, index + 1);
            }
            swap(nums, index, i);

        }
    }
}
