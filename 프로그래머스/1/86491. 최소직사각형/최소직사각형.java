class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int minMax = 1;
        int maxMax = 1;
        for(int i = 0; i < sizes.length; i++){
            int min = Math.min(sizes[i][0], sizes[i][1]);
            int max = Math.max(sizes[i][0], sizes[i][1]);
            
            minMax = Math.max(min, minMax);
            maxMax = Math.max(max, maxMax);
        }
        return minMax * maxMax;
    }
}