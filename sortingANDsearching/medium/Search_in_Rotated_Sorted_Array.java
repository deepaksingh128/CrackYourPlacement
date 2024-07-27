class Solution {
    // Algorithm :- 1. Find index of min element
    //              2. Apply Binary serach on each part
    
    public int search(int[] nums, int target) {
        int pivotIndex = findMinIndex (nums);

        if (binarySearch (nums, 0, pivotIndex - 1, target) != -1) {
            return binarySearch (nums, 0, pivotIndex - 1, target);
        }

        if (binarySearch (nums, pivotIndex, nums.length - 1, target) != -1) {
            return binarySearch (nums, pivotIndex , nums.length - 1, target);
        }

        return -1;
    }

    public int findMinIndex (int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    int binarySearch (int[] nums, int lo, int hi, int target) {
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
