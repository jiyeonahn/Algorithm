class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int day = startday;
        
        for(int i = 0; i < timelogs.length; i++){
            int max = schedules[i]%100+10 >= 60 ? (schedules[i]/100+1)*100 + schedules[i]%100+10-60 : schedules[i]+10;
            int cnt = 0;
            for(int j = 0; j < timelogs[0].length; j++){
                if(day == 8){
                    day = 1;
                }
                if(day <= 5 && timelogs[i][j] <= max){
                    cnt++;
                }
                day++;
            }
            
            if(cnt == 5){
                answer++;
            }
        }
        
        return answer;
    }
}