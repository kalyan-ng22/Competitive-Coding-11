// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We follow greedy approach to solve the remove k digits problem. To get the minimum number, the number should have the digits in the increasing
// order from left to right. So we maintain a monotonic stack and check if top of stack is greater than incoming digit while parsing from left to right, if
// found we pop it and reduce k. After parsing the String if k is still left, that means the num order is already in increasing order, so we remove the
// k digits from end of the number. We also handle the leading zeroes sceanrio and return the result.

class Solution {
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > chars[i]) { //monotonic stack and checking if top of stack is greater than incoming digit
                stack.pop();
                k--;
            }
            stack.push(chars[i]);
        }
        while (!stack.isEmpty() && k > 0) { //even if k is present remove the top of stack digits until k = 0
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop()); //build result
        }
        result.reverse(); //reverse order of popped one's from stack
        int idx = 0;
        while (idx < result.length() && result.charAt(idx) == '0') {
            idx++; //leading zeros tracking
        }
        String res = result.substring(idx);
        if (res.isEmpty()) { //edge case of result being empty
            res = "0";
        }
        return res.toString(); //result with no leading zeroes
    }
}