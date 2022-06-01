class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k) {
            return false;
        }
        int mask = Integer.parseInt(s.substring(0, k), 2);
        HashSet<Integer> set = new HashSet<>();
        set.add(mask);
        for(int i = k; i < s.length(); i++) {
            int rmp = ~(1 << (k - 1));
            mask &= rmp;
            int cur = s.charAt(i) - '0';
            mask <<= 1;
            mask |= cur;
            set.add(mask);
        }
        int reqd = (int)Math.pow(2, k);
        return set.size() == reqd;
    }
}