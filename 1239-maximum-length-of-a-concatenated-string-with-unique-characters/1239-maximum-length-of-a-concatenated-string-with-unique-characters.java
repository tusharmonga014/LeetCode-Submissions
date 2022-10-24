class Solution {
    public int maxLength(List<String> arr) {
        int masks[] = new int[arr.size()];
        boolean hasDup[] = new boolean[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            int mask = 0;
            for(char c : s.toCharArray()) {
                if((mask & (1 << (c - 'a'))) != 0) {
                    hasDup[i] = true;
                    break;
                }
                mask |= (1 << (c - 'a'));
            }
            masks[i] = mask;
        }
        
        return ans(arr, 0, masks, 0, hasDup);
    }
    
    public int ans(List<String> arr, int i, int[] masks, int mask, boolean[] hd) {
        if(i == arr.size()) {
            return 0;
        }
        
        int max = ans(arr, i + 1, masks, mask, hd);
        
        if(!hd[i] && (mask & masks[i]) == 0) {
            max = Math.max(max, ans(arr, i + 1, masks, (mask | masks[i]), hd) + arr.get(i).length());
        }
        
        return max;
    }
}