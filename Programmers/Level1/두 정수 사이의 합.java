class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        if(a != b){

            if(a > b){
                int temp = a;
                a = b;
                b= temp;
            }

            for(int i=a; i<=b;i++){
                answer +=i;
            }

        }else{
            answer = a;
        }

        return answer;
    }
}