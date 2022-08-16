class Solution {
    public int firstUniqChar(String s) {
        Integer ch[] = new Integer[26];
        for(int i = 0; i < s.length(); i++) {
            if(ch[s.charAt(i) - 'a'] == null) {
                ch[s.charAt(i) - 'a'] = i;
            } else if(ch[s.charAt(i) - 'a'] == Integer.MAX_VALUE) {
                continue;
            } else {
                ch[s.charAt(i) - 'a'] = Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if(ch[i] != null) {
                min = Math.min(min, ch[i]);
            }
        }
        return (min == Integer.MAX_VALUE) ?  -1 : min;
    }
}