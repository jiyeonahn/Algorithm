class Solution {
    public int solution(int num) {
        int answer = 0;
        long lnum = num;
        while(lnum != 1){
            if(answer == 500) return -1;
            if(lnum%2 == 0){
                lnum = lnum/2;
            }else{
                lnum = lnum * 3 + 1;
            }
            answer++;
        }
        return answer;
    }
}