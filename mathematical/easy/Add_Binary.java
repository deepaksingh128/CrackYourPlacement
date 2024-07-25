class Solution {
  // We can write better code as well :-
  
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        int i = n - 1, j = m - 1; 
        StringBuilder ans = new StringBuilder();

        int currCarry = 0;

        while (i >= 0 && j >= 0) {
            char ch = a.charAt(i);
            char ch2 = b.charAt(j);

            if (currCarry == 0) {
                if (ch == '0' && ch2 == '0') {
                    ans.append('0');
                } else if (ch == '0' && ch2 == '1') {
                    ans.append('1');
                } else if (ch == '1' && ch2 == '0') {
                    ans.append('1');
                } else {
                    ans.append('0');
                    currCarry = 1;
                }
            } else {
                if (ch == '0' && ch2 == '0') {
                    ans.append('1');
                    currCarry = 0;
                } else if (ch == '0' && ch2 == '1') {
                    ans.append('0');
                    currCarry = 1;
                } else if (ch == '1' && ch2 == '0') {
                    ans.append('0');
                    currCarry = 1;
                } else {
                    ans.append('1');
                    currCarry = 1;
                }
            }
            i --;
            j --;
        }

        while (i >= 0) {
            char ch = a.charAt(i);

            if (currCarry == 0) {
                ans.append(ch);
            } else if (ch == '0'){
                ans.append('1');
                currCarry = 0;
            } else {
                ans.append('0');
                currCarry = 1;
            }

            i --;
        }

         while (j >= 0) {
            char ch = b.charAt(j);

            if (currCarry == 0) {
                ans.append(ch);
            } else if (ch == '0'){
                ans.append('1');
                currCarry = 0;
            } else {
                ans.append('0');
                currCarry = 1;
            }

            j --;
        }

        if (currCarry == 1) {
            ans.append('1');
        }

        return ans.reverse().toString();
    }
}
