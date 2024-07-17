class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();


        for (int i = 0; i < n - 3; i ++ ) {
            // to avoid duplicates
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j ++) {
                // to avoid duplicates
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k ++;
                        l --;

                        // to avoid duplicates
                        while (k < l && nums[k] == nums[k-1]) {
                            k ++;
                        }
                        // to avoid duplicates
                        while (k < l && nums[l] == nums[l+1]) {
                            l --;
                        }
                    } else if (sum > target) {
                        l --;
                    } else {
                        k ++;
                    }
                }
            }
        }

        return res;
    }
}
