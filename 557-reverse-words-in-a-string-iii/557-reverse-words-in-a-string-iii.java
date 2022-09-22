class Solution {
    public String reverseWords(String s) {
        char ch[] = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(ch[i] == ' ') {
                continue;
            } else {
                int st = i;
                while(i < s.length() && ch[i] != ' ') {
                    i++;
                }
                int end = i - 1;
                while(st < end) {
                    char temp = ch[st];
                    ch[st] = ch[end];
                    ch[end] = temp;
                    st++;
                    end--;
                }
            }
        }
        return new String(ch);
    }
}