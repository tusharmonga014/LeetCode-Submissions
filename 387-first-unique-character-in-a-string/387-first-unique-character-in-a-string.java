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
        for(int i = 0; i < 26; i++) {
            if(ch[i] == null) {
                ch[i] = Integer.MAX_VALUE;
            }
        }
        Arrays.sort(ch);
        return (ch[0] == Integer.MAX_VALUE) ?  -1 : ch[0];
    }
}