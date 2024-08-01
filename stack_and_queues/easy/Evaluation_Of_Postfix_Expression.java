class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        int n = S.length();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        
        for (int i=0; i<n; i++) {
            char ch = S.charAt (i);
            
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int operandTwo = st.pop();
                int operandOne = st.pop();
                
                int ans = 0;
                switch (ch) {
                    case '+':
                        ans = operandOne + operandTwo;
                        break;
                    case '-':
                        ans = operandOne - operandTwo;
                        break;
                    case '*':
                        ans = operandOne * operandTwo;
                        break;
                    case '/':
                        ans = operandOne / operandTwo;
                        break;
                }
                
                st.push(ans);
            } else {
                st.push (ch - '0');
            }
        }
        
        return st.pop();
    }
}
