class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            
            int freq[] = new int[26];
            for(char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                if(freq[i] > 0) {
                    char ch = (char)(i + 'a');
                    sb.append(ch + "" + freq[i]);
                }
            }
            
            String freqStr = sb.toString();
            if(map.containsKey(freqStr)) {
                map.get(freqStr).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(freqStr, list);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String s : map.keySet()) {
            ans.add(map.get(s));
        }
        
        return ans;
    }
}