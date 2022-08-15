class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0) {
            return 0;
        }
        
        if(s.charAt(0) == 'M') {
            return 1000 + romanToInt(s.substring(1));
        } else if(s.charAt(0) == 'D') {
            return 500 + romanToInt(s.substring(1));
        } else if(s.charAt(0) == 'C') {
            if(s.length() > 1) {
                if(s.charAt(1) == 'D') {
                    return 400 + romanToInt(s.substring(2));
                } else if(s.charAt(1) == 'M') {
                    return 900 + romanToInt(s.substring(2));
                } else {
                    return 100 + romanToInt(s.substring(1));
                }
            } else {
                return 100;
            }
        } else if(s.charAt(0) == 'L') {
            return 50 + romanToInt(s.substring(1));
        } else if(s.charAt(0) == 'X') {
            if(s.length() > 1) {
                if(s.charAt(1) == 'L') {
                    return 40 + romanToInt(s.substring(2));
                } else if(s.charAt(1) == 'C') {
                    return 90 + romanToInt(s.substring(2));
                } else {
                    return 10 + romanToInt(s.substring(1));
                }
            } else {
                return 10;
            }
        } else if(s.charAt(0) == 'V') {
            return 5 + romanToInt(s.substring(1));
        } else if(s.charAt(0) == 'I') {
            if(s.length() > 1) {
                if(s.charAt(1) == 'V') {
                    return 4 + romanToInt(s.substring(2));
                } else if(s.charAt(1) == 'X') {
                    return 9 + romanToInt(s.substring(2));
                } else {
                    return 1 + romanToInt(s.substring(1));
                }
            } else {
                return 1;
            }
        }
        return 0;
    }
}