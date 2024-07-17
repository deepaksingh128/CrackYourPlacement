class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int j, k, sum;

        for (int i=0; i<n-2; i ++) {
            // avoids duplicate nums[i]
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            j = i + 1;
            k = n - 1;

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j ++;
                    k --;
                    // avoids duplicate nums[j]
                    while (j < k && nums[j] == nums[j-1] ){
                        j ++;
                    }
                    // avoids duplicate nums[k]
                    while (j < k && nums[k] == nums[k+1] ) {
                        k --;
                    }
                } else if (sum > 0) {
                    k --;
                } else {
                    j ++;
                }
            }
        }

        return res;
    }
}
