class Solution {
    public int maxProduct(String[] words) {
        int mask[] = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            for(int c = 0; c < s.length(); c++) {
                char ch = s.charAt(c);
                int pos = ch - 'a';
                int cmask = (1 << pos);
                mask[i] = (mask[i] | cmask);
            }
        }
        
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}