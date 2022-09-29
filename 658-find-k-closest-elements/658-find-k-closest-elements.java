class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int start = 0;
        
        for(int i = k; i < arr.length; i++){
            if(Math.abs(x - arr[i]) < Math.abs(x - arr[start])){
                start++;
            } else {
                if(arr[i] == arr[i - 1]){
                    if(arr[i] > arr[start])
                        break;
                    start++;
                }
                else {
                    break;
                }
            }
        }
               
        for(int i = start, count = 1; count <= k; i++, count++){
            ans.add(arr[i]);
        }
        
        return ans;
    }
}