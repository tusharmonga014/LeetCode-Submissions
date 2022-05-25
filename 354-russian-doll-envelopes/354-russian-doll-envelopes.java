class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a,b)->{
            if(a[0] != b[0])
                return a[0] - b[0];
            else 
                return b[1] - a[1];
        });
        
        int ans = 0;
        
        int lis = findLis(envelopes);
        ans = lis;
        
        return ans;
    }
    
    public int findLis(int[][] arr){
        
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(dp.size() == 0 || dp.get(dp.size() - 1) < arr[i][1]){
                    dp.add(arr[i][1]);
            } else {
                int idx = findSearchPosition(dp, arr[i][1]);
                dp.set(idx, arr[i][1]);
            }
        }
        
        return dp.size();
    }
    
    public int findSearchPosition(ArrayList<Integer> arr, int data){
        int li = 0;
        int ri = arr.size() - 1;
        
        if(data < arr.get(0)) return li;
        
        while(li <= ri){
            int mid = (li + ri) / 2;
            if(arr.get(mid) < data){
                li = mid + 1;
            } else if (arr.get(mid) > data){
                ri = mid - 1;
            } else {
                return mid;
            }
        }
        
        return li;
    }
}