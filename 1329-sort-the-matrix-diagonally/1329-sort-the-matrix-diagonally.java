class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int c = mat[0].length - 1; c >= 0; c--) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0, j = c; i < mat.length && j < mat[i].length; i++, j++) {
                pq.add(mat[i][j]);
            }
            for(int i = 0, j = c; i < mat.length && j < mat[i].length; i++, j++) {
                mat[i][j] = pq.poll();
            }
        }
        for(int r = 1; r < mat.length; r++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = r, j = 0; i < mat.length && j < mat[i].length; i++, j++) {
                pq.add(mat[i][j]);
            }
            for(int i = r, j = 0; i < mat.length && j < mat[i].length; i++, j++) {
                mat[i][j] = pq.poll();
            }
        }
        return mat;
    }
}