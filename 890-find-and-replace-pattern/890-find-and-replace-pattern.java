class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for(String word : words) {
            if(satisfiesPattern(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }
    public boolean satisfiesPattern(String word, String pattern) {
        Character ch[] = new Character[26];
        Character mapped[] = new Character[26];
        for(int i = 0; i < word.length(); i++) {
            char wth = word.charAt(i);
            char pth = pattern.charAt(i);
            if(ch[wth - 'a'] != null) {
                if(ch[wth -'a'] != pth) {
                    return false;
                }
            } else if(mapped[pth - 'a'] != null) {
                return false;
            } else {
                ch[wth - 'a'] = pth;
                mapped[pth - 'a'] = wth;
            }
        }
        return true;
    }
}