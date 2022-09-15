class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n % 2 != 0) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int or[] = new int[n / 2];
        for(int i = 0; i < n; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        int fill = 0;
        Arrays.sort(changed);
        for(int i = n - 1; i >= 0; i--) {
            if(map.containsKey(changed[i])) {
                if(changed[i] % 2 == 0 && map.containsKey(changed[i] / 2)) {
                    remove(changed[i], map);
                    remove(changed[i] / 2, map);
                    or[fill++] = changed[i] / 2;
                } else {
                    return new int[0];
                }
            }
        }
        return or;
    }
    private void remove(int ele, HashMap<Integer, Integer> map) {
        int freq = map.get(ele);
        if(freq == 1) map.remove(ele);
        else map.put(ele, freq - 1);
    }
}