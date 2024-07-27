class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int [] temp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort (temp);
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<temp.length; i++) {
            map.put (temp[i], i);
        }
    
        int noOfSwaps = 0;    
        for (int i=0; i<nums.length; i++) {
            if (map.get(nums[i]) != i) {
                noOfSwaps ++;
                // swap
                int t = nums[map.get(nums[i])];
                nums[map.get(nums[i])] = nums[i];
                nums[i] = t;
                
                i --;
            }
        }
        
        return noOfSwaps;
    }
}
