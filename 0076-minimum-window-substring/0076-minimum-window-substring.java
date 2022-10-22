class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        
        HashMap<Character, Integer> omap = new HashMap<>();
        for(char c : t.toCharArray()) {
            omap.put(c, omap.getOrDefault(c, 0) + 1);
            
        }
         
        int ans = 0;
        int ansi = -1;
        int ansj = -1;
        
        int mct = 0;
        int dmct = t.length();
        HashMap<Character, Integer> fmap = new HashMap<>();
        
        int i = -1;
        int j = -1;
        
        boolean flag1 = true;
        boolean flag2 = true;
                
        while(flag1 || flag2) {
            
            flag1 = false;
            flag2 = false;
            
            // acquire while matchCount != desired_mct
            while(i < s.length() - 1 && mct < dmct) {
                i++;
                
                char c = s.charAt(i);
                
                fmap.put(c, fmap.getOrDefault(c, 0) + 1);
                
                if(fmap.getOrDefault(c, 0) <= omap.getOrDefault(c, 0))
                    mct++;
                
                flag1 = true;
            }
            
            // update ans, relase answer, untill mct does not drop
            while(j < i && mct == dmct) {
                
                int potential_ans = (i - j);
                if(ans == 0 || potential_ans < ans) {
                    ans = potential_ans;
                    ansi = i;
                    ansj = j;
                }
                         
                j++;
                
                char c = s.charAt(j);
                
                fmap.put(c, fmap.get(c) - 1);
                
                if(fmap.getOrDefault(c, 0) < omap.getOrDefault(c, 0))
                    mct--;
                
                flag2 = true;
            }
        }
        
        if(ans == 0) return "";
        else return s.substring(ansj + 1, ansi + 1);
        
        
        
//         if(s2.length() == 1){
//             for(int i = 0 ; i < s1.length(); i++){
//                 if(s1.charAt(i) == s2.charAt(0)){
//                     return s2;
//                 }
//             }
//             return "";
//         }
        
//         HashMap<Character,Integer> map1 = new HashMap<>();
// 	    HashMap<Character,Integer> map2 = new HashMap<>();
// 	    for(int i = 0 ; i < s2.length(); i++){
// 	        char ch = s2.charAt(i);
// 	        map2.put(ch,map2.getOrDefault(ch,0) + 1);
// 	    }
	    
// 	    int ans = Integer.MAX_VALUE;
// 	    int matchcount = 0;
// 	    int[] fans = new int[2];
// 	    for(int i = 0, j = 0; i < s1.length(); i++){
// 	        char c = s1.charAt(i);
// 	        if(map2.containsKey(c)){
// 	            map1.put(c,map1.getOrDefault(c,0) + 1);
// 	            if(map1.get(c) <= map2.get(c)){
// 	                matchcount++;
// 	            }
// 	            while(matchcount == s2.length()){
// 	                char chj = s1.charAt(j);
// 	                if(!map1.containsKey(chj)){
// 	                    //nothing
// 	                }else if(map1.get(chj) > map2.getOrDefault(chj,0)){
// 	                    map1.put(chj,map1.get(chj) - 1);
// 	                }else{
// 	                    if(i - j + 1 < ans){
// 	                        ans = i - j + 1;
// 	                        fans[0] = i;
// 	                        fans[1] = j;
// 	                    }
// 	                    map1.put(chj,map1.get(chj) - 1);
// 	                    if(map1.get(chj) < 0){
// 	                        map1.remove(chj);
// 	                    }
// 	                    matchcount--;
// 	                }
// 	                j++;
// 	            }
	           
// 	        }    
	        
// 	    }
// 	    if(fans[0] == fans[1] && s2.length() != 1){
// 	        return "";
// 	    }else
// 	    return (s1.substring(fans[1],fans[0] + 1));
    }
}