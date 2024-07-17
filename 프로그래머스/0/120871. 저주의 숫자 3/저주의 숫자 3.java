class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            answer++;
            while(true){
                if(answer%3!=0 && !String.valueOf(answer).contains("3")) break;
                if(answer%3==0) answer++;
                if(String.valueOf(answer).contains("3")) answer++;
            }
        }
        
        return answer;
    }
}