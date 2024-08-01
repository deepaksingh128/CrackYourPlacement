class Solution {
    // Using stack => s.c.=> O(n)
    
    public boolean backspaceCompare(String s, String t) {
        String convertedS = convert (s);
        String convertedT = convert (t);

        return convertedS.equals(convertedT);
    }

    public String convert (String str) {
        ArrayDeque<Character> st = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }
}
