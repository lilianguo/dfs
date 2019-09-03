public class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String,List<String>> prefixTable = new HashMap<>();
        createPrefixTable(words, prefixTable);
        List<String> curr = new ArrayList<>();
        dfs(0, words[0].length(), prefixTable, curr, res);
        return res;
    }
    
    private void createPrefixTable(String[] words, Map<String,List<String>> prefixTable) {
        for (String word : words) {
            prefixTable.putIfAbsent("", new ArrayList<>());
            prefixTable.get("").add(word);
            String prefix = "";
            for (char c : word.toCharArray()) {
                prefix += c;
                prefixTable.putIfAbsent(prefix, new ArrayList<>());
                prefixTable.get(prefix).add(word);
            }
        }
    }
    
    private void dfs(int nextRow, int wordLen, Map<String,List<String>> prefixTable, List<String> curr, List<List<String>> res) {
        if (nextRow == wordLen) {
            res.add(new ArrayList<>(curr));
            return;
        }
        String prefix = "";
        for (int i = 0; i < nextRow; i++) {
            prefix += curr.get(i).charAt(nextRow);
        }
        
        for (String next : prefixTable.get(prefix)) {
            if (!checkPrefix(next, nextRow, wordLen, prefixTable, curr)) {
                continue;
            }
            curr.add(next);
            dfs(nextRow + 1, wordLen, prefixTable, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
    
    private boolean checkPrefix(String next, int nextRow, int wordLen, Map<String,List<String>> prefixTable, List<String> curr) {
        for (int start = nextRow + 1; start < wordLen; start++) {
            String prefix = "";
            for (int k = 0; k < nextRow; k++) {
                prefix += curr.get(k).charAt(start);
            }
            prefix += next.charAt(start);
            if (!prefixTable.containsKey(prefix)) {
                return false;
            }
        }
        return true;
    }
}