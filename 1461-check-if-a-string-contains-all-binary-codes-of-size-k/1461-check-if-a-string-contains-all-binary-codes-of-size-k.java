class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i <= s.length() - k; i++) {
            int v = Integer.parseInt(s.substring(i, i + k), 2);
            set.add(v);
        }
        int reqd = (int)Math.pow(2, k);
        return set.size() == reqd;
    }
}