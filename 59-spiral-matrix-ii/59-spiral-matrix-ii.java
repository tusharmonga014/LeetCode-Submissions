class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        
        int tne = n * n;
        int ele = 1;
        
        int sr = 0;
        int er = n - 1;
        int sc = 0;
        int ec = n - 1;
        
        while(ele <= tne){
            for(int i = sc; i <= ec && ele <= tne; i++){
                mat[sr][i] = ele;
                ele++;
            }
            sr++;
            
            for(int i = sr; i <= er && ele <= tne; i++){
                mat[i][ec] = ele;
                ele++;
            }
            ec--;
            
            for(int i = ec; i >= sc && ele <= tne; i--){
                mat[er][i] = ele;
                ele++;
            }
            er--;
            
            for(int i = er; i >= sr && ele <= tne; i--){
                mat[i][sc] = ele;
                ele++;
            }
            sc++;
        }
        
        return mat;
    }
}