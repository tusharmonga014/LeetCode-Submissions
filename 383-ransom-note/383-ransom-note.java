class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int m[] = new int[26];
        for(char c : magazine.toCharArray()) m[c - 'a']++;
        for(char c : ransomNote.toCharArray()) {
            if(m[c - 'a'] == 0) return false;
            else m[c - 'a']--;
        }
        return true;
    }
}