class Solution {
    public int minSetSize(int[] arr) {
        Integer map[] = new Integer[100001];
        Arrays.fill(map, 0);
        for(int ele : arr) {
            map[ele]++;
        }
        Arrays.sort(map, Collections.reverseOrder());
        int set = 0;
        int count = 0;
        int sz_2 = arr.length / 2;
        for(int ele : map) {
            set += ele;
            count++;
            if(set >= sz_2) {
                break;
            }
        }
        return count;
    }
}