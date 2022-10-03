class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        for(int i = 0; i < colors.length(); i++) {
            int currentColor = colors.charAt(i);
            int maxTimeForCurrentColor = neededTime[i];
            int totalTimeForCurrentColor = neededTime[i];
            while(i + 1 < colors.length() && colors.charAt(i + 1) == currentColor) {
                maxTimeForCurrentColor = Math.max(maxTimeForCurrentColor, neededTime[i + 1]);
                totalTimeForCurrentColor += neededTime[i + 1];
                i++;
            }
            time += (totalTimeForCurrentColor - maxTimeForCurrentColor);
        }
        return time;
    }
}