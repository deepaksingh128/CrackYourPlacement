class Solution {

    public int merge (int[] nums, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        // calculate reverse pairs first
        while (i <= mid && j <= hi) {
            if (nums[i] > 2*(long)nums[j]) {
                count += (mid - i + 1);
                j ++;
            } else {
                i ++;
            }
        }

        // now merge
        i = lo;
        j = mid + 1;

        while (i <= mid && j <= hi) {
            if (nums[i] <= nums[j]) {
                list.add(nums[i]);
                i ++;
            } else {
                list.add(nums[j]);
                j ++;
            }
        }

        while (i <= mid) {
            list.add(nums[i]);
            i ++;
        }

        while (j <= hi) {
            list.add(nums[j]);
            j ++;
        }

        // copy to original array
        i = lo;
        for (int e : list) {
            nums[i] = e;
            i ++;
        }

        return count;
    }

    public int mergeSort (int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        int count = 0;

        count += mergeSort (nums, lo, mid);
        count += mergeSort (nums, mid + 1, hi);

        count += merge (nums, lo, mid, hi);

        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort (nums, 0, nums.length - 1);
    }
}
