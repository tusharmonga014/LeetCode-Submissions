class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> base = new ArrayList<>();
        base.add(1);
        ans.add(base);
        
        for(int i = 2; i <= numRows; i++) {
            List<Integer> smallAns = new ArrayList<>();
            for(int j = 1; j <= i; j++) {
                if(j == 1 || j == i) {
                    smallAns.add(1);
                } else {
                    int cur = ans.get(ans.size() - 1).get(j - 2) + ans.get(ans.size() - 1).get(j - 1);  // as j is from 1 to iand we need in index form.
                    smallAns.add(cur);
                }
            }
            ans.add(smallAns);
        }
        return ans;
    }
}