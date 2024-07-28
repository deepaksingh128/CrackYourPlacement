class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        String binary = "";

        while (temp != null) {
            binary += (char)temp.val;
            temp = temp.next;
        }

        return binaryToDecimal(binary);
    }
    public int binaryToDecimal (String binary) {
        int number = 0;
        int idx = binary.length() - 1;

        while (idx >= 0) {
            int bit = binary.charAt(idx);
            int placeValue = (int)Math.pow (2, binary.length() - idx - 1);

            number += bit * placeValue;
            idx --;
        }

        return number;
    }
}
