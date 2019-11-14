/*
32. Longest Valid Parentheses
Hard

Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses subsequence.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses subseq is "()"

Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses subseq is "()()"

Example 2:

Input: "()(()"
Output: 4
Explanation: The longest valid parentheses subseq is "()()"

*/
class LongestValidParenthesesSubseq {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int open = 0;
        int close = 0;
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                open++;
            } else {
                if (!stack.isEmpty() && open > close) {
                    stack.push(c);
                    close++;
                }
            }
        }
        return stack.size() - (open - close);
    }
}