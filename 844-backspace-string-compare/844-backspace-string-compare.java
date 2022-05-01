class Solution {
    public boolean backspaceCompare(String s, String t) {
        int ignores = 0;
        int ignoret = 0;
        
        int i = s.length() - 1;
        int j = t.length() - 1;
        
        while(i >= 0 && j >= 0) {
            char sth = s.charAt(i);
            char tth = t.charAt(j);
            
            if(sth == '#' || tth == '#') {
            
                if(sth == '#') {
                    ignores++;
                    i--;
                }
                if(tth == '#') {
                    ignoret++;
                    j--;
                }
            
            } else if(ignores > 0 || ignoret > 0) {
                
                if(ignores > 0) {
                    ignores--;
                    i--;
                }
                if(ignoret > 0) {
                    ignoret--;
                    j--;
                }
            
            } else {
                
                if(sth != tth) {
                    return false;
                } else {
                    i--;
                    j--;
                }
            
            }
        }
        
        while(i >= 0) {
            if(s.charAt(i) == '#') {
                ignores++;
                i--;
            } else {
                if(ignores > 0) {
                    ignores--;
                    i--;
                } else {
                    return false;
                }
            }
        }
        
       while(j >= 0) {
            if(t.charAt(j) == '#') {
                ignoret++;
                j--;
            } else {
                if(ignoret > 0) {
                    ignoret--;
                    j--;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}