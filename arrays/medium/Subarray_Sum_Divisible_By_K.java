class Solution {
    // t.c.=> O(n)  , s.c.=> O(n)
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map =  new HashMap<>();
        map.put(0, 1);

        int n = nums.length;
        int preSum = 0;
        int count = 0;

        for (int i=0; i<n; i++) {
            preSum += nums[i];

            int rem = preSum % k;
            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                count += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put (rem, 1);
            }
        }

        return count;
    }
}
