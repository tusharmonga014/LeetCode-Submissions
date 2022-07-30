class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        
        int ch2[] = new int[26];
        for(String word : words2) {
            int tch2[] = new int[26];
            for(int i = 0; i < word.length(); i++) {
                tch2[word.charAt(i) - 'a']++;
            }
            for(int i = 0; i < 26; i++) {
                ch2[i] = Math.max(ch2[i], tch2[i]);
            }
        }
        
        for(String word : words1) {
            int ch1[] = new int[26];
            for(int i = 0; i < word.length(); i++) {
                ch1[word.charAt(i) - 'a']++;
            }
            boolean fits = true;
            for(int i = 0; i < 26; i++) {
                if(ch1[i] < ch2[i]) {
                    fits = false;
                    break;
                }
            }
            if(fits) {
                ans.add(word);
            }
        }
        
        return ans;
    }
}