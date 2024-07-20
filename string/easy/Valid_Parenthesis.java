class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.size() == 0) return false;
                if(st.peek() == '(' && ch == ')'){
                    st.pop();
                }else if(st.peek() == '{' && ch == '}'){
                    st.pop();
                }else if(st.peek() == '[' && ch == ']'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }else{
            return false;
        } 
    }
}
