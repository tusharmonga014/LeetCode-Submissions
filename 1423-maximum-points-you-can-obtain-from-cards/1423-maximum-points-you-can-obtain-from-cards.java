class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ps[] = new int[cardPoints.length];
        int ss[] = new int[cardPoints.length];
        
        ps[0] = cardPoints[0];
        for(int i = 1; i < cardPoints.length; i++) {
            ps[i] = ps[i - 1] + cardPoints[i];
        }
        
        ss[cardPoints.length - 1] = cardPoints[cardPoints.length - 1];
        for(int i = cardPoints.length - 2; i >= 0; i--) {
            ss[i] = ss[i + 1] + cardPoints[i];
        }
        
        int sum = Integer.MIN_VALUE;
        int all1 = ps[k - 1];
        int all2 = ss[cardPoints.length - k];
        sum = Math.max(all1, all2);
        for(int i = 0; i < k - 1; i++) {
            int j = cardPoints.length - (k - (i + 1));
            int csum = ps[i] + ss[j];
            sum = Math.max(sum, csum);
        }
        
        return sum;
    }
}