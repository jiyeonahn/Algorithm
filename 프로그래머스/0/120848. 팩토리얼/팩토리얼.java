class Solution {
    public int solution(int n) {
        int answer = 1;
        int sum = 1;
        
        for(int i = 2; i <= n; i++){
            sum *= i;
            if(sum > n) break;
            answer = i;
        }
        return answer;
    }
}