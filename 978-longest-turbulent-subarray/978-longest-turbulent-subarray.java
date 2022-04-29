class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // even -> big
        int t1[] = new int[arr.length];
        // odd big
        int t2[] = new int[arr.length];
        
        int max = 1;
        
        Arrays.fill(t1, 1);
        Arrays.fill(t2, 1);
        
        for(int i = arr.length - 2; i >= 0; i--) {
            if(i % 2 == 0) {
                if(arr[i] > arr[i + 1]) {
                    t1[i] = t1[i + 1] + 1;
                } else if(arr[i] < arr[i + 1]){
                    t2[i] = t2[i + 1] + 1;
                }
            } else {
                if(arr[i] < arr[i + 1]) {
                    t1[i] = t1[i + 1] + 1;
                } else if(arr[i] > arr[i + 1]){
                    t2[i] = t2[i + 1] + 1;
                }
            }
           
            max = Math.max(max, Math.max(t1[i], t2[i]));
        }
                
        return max;
    }
}