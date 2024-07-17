class Solution {

    // We can also use binary search to solve this problem ,
    // in that case t.c.=> O(n*logn) , s.c.=> O(1)
    // In this case (hare and tortoise) => t.c.=> O(n) , sc.=> O(1)

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = 0;

        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);

        return slow;
    }
}
