class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean ch[] = new boolean[26];
        for(int i = 0; i < sentence.length(); i++) {
            ch[sentence.charAt(i) - 'a'] = true;
        }
        for(int i = 0; i < 26; i++) {
            if(!ch[i]) return false;
        }
        return true;
    }
}