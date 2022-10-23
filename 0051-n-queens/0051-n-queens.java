class Solution {
    public List<List<String>> solveNQueens(int n) {
        aqs = new ArrayList<>();
        for(int i = 0; i < n; i++) blank += ".";
        ans(n, 0, 0, 0, 0, new ArrayList<>());
        return aqs;
    }
    List<List<String>> aqs;
    String blank = "";
    public void ans(int n, int row, int col, int diag, int adiag, List<String> qs) {
        if(row == n) {
            aqs.add(new ArrayList<>(qs));
            return;
        }
        for(int i = 0; i < n; i++) {
            int cm = (1 << i);
            int dm = (1 << (row + i));
            int adm = (1 << ((n - 1) - (row - i)));
            
            if((col & cm) == 0 && (diag & dm) == 0 && (adiag & adm) == 0) {
                col ^= cm;
                diag ^= dm;
                adiag ^= adm;
                
                String q = blank.substring(0, i) + "Q" + blank.substring(i + 1, n);
                qs.add(q);
                ans(n, row + 1, col, diag, adiag, qs);
                qs.remove(qs.size() - 1);
                
                col ^= cm;
                diag ^= dm;
                adiag ^= adm;
            }
        }
    }
}