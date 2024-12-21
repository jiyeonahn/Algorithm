class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int number = 0;
        for(int i = 0; i < num; i++){
            if(num%2 != 0){
                number = (total/num) - (num-1)/2 + i;
            }else{
                number = (total/num) - (num)/2 + 1 + i;
            }
            answer[i] = number;
        }
        return answer;
    }
}