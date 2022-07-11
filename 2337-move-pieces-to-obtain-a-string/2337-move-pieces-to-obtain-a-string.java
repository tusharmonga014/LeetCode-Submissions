class Solution {
    public boolean canChange(String s, String t) {
        String start = s;
        String target = t;
        boolean lr[][] = new boolean[start.length()][2];
        int ll[] = new int[start.length()];
        // 0 -> l
        // 1 -> r
        int l = 0;
        int r = 0;
        boolean rs = false;
        for(int i = 0; i < start.length(); i++) {
            if(start.charAt(i) == 'R') {
                rs = true;
                lr[i][1] = true;
            } else if(start.charAt(i) == 'L') {
                rs = false;
                lr[i][1] = false;
            } else {
                lr[i][1] = rs;
            }
            r++;
        }
        boolean ls = false;
        int lls = -1;
        for(int i = start.length() - 1; i >= 0; i--) {
            if(start.charAt(i) == 'L') {
                ls = true;
                lr[i][0] = true;
                lls = i;
                ll[i] = i;
            } else if(start.charAt(i) == 'R') {
                ls = false;
                // lr[i][0] = false;
            } else {
                lr[i][0] = ls;
                if(ls) {
                    ll[i] = lls;
                }
            }
            l++;
        }
        if(l != r) {
            // return false;
        }
//         int r_ = -1;
//         for(int i= 0; i < start.length(); i++) {
//             char t = target.charAt(i);
//             if(start.charAt(i) == 'R'){
//                 r_ = -1;
//             }
//             if(t == 'L') {
//                 if(lr[i][0]) {
//                     r_ = Integer.MAX_VALUE;
//                 } else {
//                     // return false;
//                 }
//             } else if(t == 'R') {
//                 if(lr[i][1] && r_ < i) {
//                     continue;
//                 } else {
//                     // return false;
//                 }
//             } else {
//                 continue;
//             }
            
//         }
        
        
        
        // int l = 0;
        // int r = 0;
        // for(int i = 0; i < start.length(); i++) {
        //     char s = start.charAT(i);
        //     char t = target.charAt(i);
        //     if(t == '_') {
        //         if(s == '_') {
        //             continue;
        //         } else if(s == 'L') {
        //             if(l == -1) {
        //                 l++;
        //                 continue;
        //             } else {
        //                 return false;
        //             }
        //         } else {
        //             r++;
        //         }
        //     } else if(t == 'L') {
        //         if(s == 'L') {
        //             continue;
        //         } else if(s == '_') {
        //             if(l > 0) {
        //                 l--;
        //                 continue;
        //             } else {
        //                 return 
        //             }
        //         }
        //     }
        // }
        int blanks = 0; 
        for (char c : s.toCharArray()) { 
            if (c == '_') blanks++; 
        } 
        for (char c : t.toCharArray()) { 
            if (c == '_') blanks--; 
        } 
        if (blanks != 0) return false; 
        
//         for(int i= 0; i < start.length(); i++) {
//             char t = target.charAt(i);
//             if(start.charAt(i) == 'R'){
//                 r_ = -1;
//             }
//             if(t == 'L') {
//                 if(lr[i][0]) {
//                     r_ = Integer.MAX_VALUE;
//                 } else {
//                     // return false;
//                 }
//             } else if(t == 'R') {
//                 if(lr[i][1] && r_ < i) {
//                     continue;
//                 } else {
//                     // return false;
//                 }
//             } else {
//                 continue;
//             }
            
//         }
        return isValid(s, t); 
        // return true;
    }
     
    public boolean isValid(String s, String t) { 
        int lll = 0, rrr = 0, LT = 0, RT = 0; 
        for (int i = 0; i < s.length(); i++) { 
            char sc = s.charAt(i); 
            char tc = t.charAt(i); 
            if (sc == 'L') lll++; 
            else if(sc == 'R') rrr++; 
            if (tc == 'L') LT++; 
            else if(tc == 'R') RT++; 
        } 
         
        if (lll != LT || rrr != RT) return false; 
        List<Integer> start = new ArrayList<>(); 
        List<Integer> target = new ArrayList<>(); 
         
        for (int i = 0; i < s.length(); i++) { 
            if (s.charAt(i) != '_') { 
                start.add(i); 
            } 
            if (t.charAt(i) != '_') { 
                target.add(i); 
            } 
        } 
         
        for (int i = 0; i < start.size(); i++) { 
            if (s.charAt(start.get(i)) != t.charAt(target.get(i))) { 
                return false; 
            } 
            if (s.charAt(start.get(i)) == 'L') { 
                if (start.get(i) < target.get(i)) { 
                    return false; 
                } 
            } else { 
                if (start.get(i) > target.get(i)) { 
                    return false; 
                } 
            } 
        } 
        return true; 
    } 
}