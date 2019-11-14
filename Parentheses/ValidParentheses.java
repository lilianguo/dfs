/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 * 
 */
class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (char c : s.substring(1).toCharArray()) {
            if (c != ']' && c != ')' && c != '}') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() != '[')) {
                    return false;
                }
                stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() != '{')) {
                    return false;
                }
                stack.pop();
            } else if (c == ')') {
                if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() != '(')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidII(String s) {
        Set<Character> set = new HashSet<>();
        set.add(')');
        set.add(']');
        set.add('}');
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != map.get(c)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}