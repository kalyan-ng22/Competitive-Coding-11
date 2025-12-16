// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We use a stack to solve the reverse polish notation problem. We push all the numbers to stack but if we encounter an operator, we perform that
// operation on the top two numbers on the stack and push the result to the stack and continue until we parse the string array.

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String token : tokens) {
            if (token.equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 + val2);
            } else if (token.equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 - val1);
            } else if (token.equals("*")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 * val2);
            } else if (token.equals("/")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 / val1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}