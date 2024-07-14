class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int maxX = Math.max(Math.max(Math.max(dots[0][0], dots[1][0]), dots[2][0]),dots[3][0]);
        int minX = Math.min(Math.min(Math.min(dots[0][0], dots[1][0]), dots[2][0]),dots[3][0]);
        int maxY = Math.max(Math.max(Math.max(dots[0][1], dots[1][1]), dots[2][1]),dots[3][1]);
        int minY = Math.min(Math.min(Math.min(dots[0][1], dots[1][1]), dots[2][1]),dots[3][1]);
        return Math.abs((maxX - minX) * (maxY - minY));
    }
}