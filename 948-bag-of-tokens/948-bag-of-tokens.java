class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int i = 0;
        int j = tokens.length - 1;
        Arrays.sort(tokens);
        int score = 0;
        int max = 0;
        while(i <= j) {
            if(power >= tokens[i]) {
                power -= tokens[i];
                score++;
                i++;
            } else if(j != i && score >= 1) {
                power += tokens[j]; 
                score--;
                j--;
            } else {
                return Math.max(max, score);
            }
            max = Math.max(max, score);
        }
        return Math.max(max, score);
    }
}