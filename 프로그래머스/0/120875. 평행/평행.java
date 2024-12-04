class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        double m1 = ((double)(dots[1][1] - dots[0][1]))/(double)(dots[1][0] - dots[0][0]);
        double m2 = ((double)(dots[3][1] - dots[2][1]))/(double)(dots[3][0] - dots[2][0]);
        
        double m3 = ((double)(dots[2][1] - dots[0][1]))/(double)(dots[2][0] - dots[0][0]);
        double m4 = ((double)(dots[3][1] - dots[1][1]))/(double)(dots[3][0] - dots[1][0]);
        
        double m5 = ((double)(dots[3][1] - dots[0][1]))/(double)(dots[3][0] - dots[0][0]);
        double m6 = ((double)(dots[2][1] - dots[1][1]))/(double)(dots[2][0] - dots[1][0]);
        
        if(m1 == m2 || m3 == m4 || m5 == m6){
            answer = 1;
        }
        return answer;
    }
}