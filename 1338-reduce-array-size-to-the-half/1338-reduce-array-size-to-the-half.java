class Solution {
    public int minSetSize(int[] arr) {
        int map[] = new int[100001];
        for(int ele : arr) {
            map[ele]++;
        }
        // System.out.println(Arrays.toString(map));
        Arrays.sort(map);
        int set = 0;
        int count = 0;
        int sz_2 = arr.length / 2;
        for(int i = map.length - 1; i >= 0; i--) {
            set += map[i];
            count++;
            if(set >= sz_2) {
                break;
            }
        }
        return count;
    }
}