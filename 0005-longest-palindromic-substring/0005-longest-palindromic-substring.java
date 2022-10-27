class Solution {
    public String longestPalindrome(String s) {
        
        int startIdx = 0;
        int maxLength = 1;
        
        int len = s.length();
        int start, end;
        
        for(int i = 1; i < len; i++){
            
            //even
            start = i - 1;
            end = i;
            while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }
            start++;
            end--;
            if(s.charAt(start) == s.charAt(end) && end - start + 1 > maxLength){
                startIdx = start;
                maxLength = end - start + 1;
            }
            
            //odd
            start = i - 1;
            end = i + 1;
            while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }
            start++;
            end--;
            if(s.charAt(start) == s.charAt(end) && end - start + 1 > maxLength){
                startIdx = start;
                maxLength = end - start + 1;
            }
        }
        
        return s.substring(startIdx, startIdx + maxLength);
    }
}