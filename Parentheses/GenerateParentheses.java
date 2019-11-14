/*
22. Generate Parentheses
Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/
class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> legal = new ArrayList<>();
        dfs(legal, "", 0, 0, n);
        return legal;
    }
    
    private void dfs(List<String> legal, String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            legal.add(curr);
            return;
        }
        if (open < max) {
            dfs(legal, curr + "(", open + 1, close, max);
        }
        if (close < open) {
            dfs(legal, curr + ")", open, close + 1, max);
        }
    }
}