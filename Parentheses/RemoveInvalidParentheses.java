class RemoveInvalidParentheses {
    char[][] patterns = new char[][] {{'(', ')'}, {')', '('}};
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, 0, patterns[0], res);
        return res;
    }
    
    private void dfs(String s, int start, int lastRemove, char[] pattern, List<String> res) {
        int cnt = 0;
        int length = s.length();
        for (int i = start;i < length; i++) {
            if (s.charAt(i) == pattern[0]) {
                cnt++;
            }
            if (s.charAt(i) == pattern[1]) {
                cnt--;
            }
            // 括号不合法了
            if (cnt < 0) {
                for (int j = lastRemove; j <= i; j++) {
                    // 从lastRemove开始删， 如果 是第一个符号，或者是连续相同括号的第一个，那么可以删完得到unique
                    if (s.charAt(j) == pattern[1] && (j == lastRemove || s.charAt(j) != s.charAt(j - 1))) {
                        // 删除位置j, 那么前面的(0, j) substring就合法了，从这个删过的string, 位置 i 之前就是合法的了，就可以从i 开始搜
                        // 可以开始删的位置就是 j
                        dfs(s.substring(0, j) + s.substring(j + 1), i, j, pattern, res);
                    }
                }
                return;
            }
        }

        // 正着扫完一遍之后，看需不需要反着扫一遍，判断条件是参数pattern 是（） 还是)(
        StringBuilder sb = new StringBuilder(s);
        // 如果是正着扫的，那这里reverse正好为反着扫做准备，
        // 如果是反着扫的，那这里正好reverse回正序，得到答案
        s = sb.reverse().toString();
        if (pattern[0] == '(') {
            dfs(s, 0, 0, patterns[1], res);
        } else {
            res.add(s);
        }
        return;
    }
}