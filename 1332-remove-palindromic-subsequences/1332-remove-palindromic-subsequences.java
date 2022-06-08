class Solution {
    public int removePalindromeSub(String s) {
        if(isPal(s))
            return 1;
        boolean containsA = false;
        boolean containsB = false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                containsA = true;
            } else {
                containsB = true;
            }
            if(containsA && containsB) {
                return 2;
            }
        }
        return 1;
    }
    
    public boolean isPal(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}