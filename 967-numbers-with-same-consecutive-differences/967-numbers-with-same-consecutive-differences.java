class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            ArrayList<Integer> smallAns = solve(n - 1, k, 1, i);
            for(int ele : smallAns) {
                int e = i * (int)Math.pow((int)10, (int)(n - 1));
                ans.add(e + ele);
            }
        }
        int ans_[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            ans_[i] = ans.get(i);
        }
        return ans_;
    }
    
    private ArrayList<Integer> solve(int n, int k, int i, int p) {
        if(n == 0) {
            ArrayList<Integer> base = new ArrayList<>();
            base.add(0);
            return base;
        }
        ArrayList<Integer> myAns = new ArrayList<>();
        if(p + k <= 9) {
            ArrayList<Integer> smallAns = solve(n - 1, k, i + 1, p + k);
            for(int ele : smallAns) {
                int e = (p + k) * (int)Math.pow((int)10, (int)(n - 1));
                myAns.add(e + ele);
            }
        }
        if(p - k >= 0 && k != 0) {
            ArrayList<Integer> smallAns = solve(n - 1, k, i + 1, p - k);
            for(int ele : smallAns) {
                int e = (p - k) * (int)Math.pow((int)10, (int)(n - 1));
                myAns.add(e + ele);
            }
        }
        return myAns;
    }
}