class Solution {
    public int countSubstrings(String s) {
        
        int count = s.length();
        
        int len = s.length();
        int start, end;
        
        for(int i = 1; i < len; i++){
            
            //even
            start = i - 1;
            end = i;
            while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
                count++;
            }
            
            //odd
            start = i - 1;
            end = i + 1;
            while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
                count++;
            }
        }
        
        return count;
        
    }
}