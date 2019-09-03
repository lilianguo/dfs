class ValidateWordSquare {
    // https://leetcode.com/problems/valid-word-square/
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0 || words.get(0).length() == 0) {
            return true;
        }
        if (words.size() != words.get(0).length()) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= words.size() || i >= words.get(j).length()) {
                    return false;
                }
                if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}