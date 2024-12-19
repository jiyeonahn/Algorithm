class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int b = 0;
        int y = 0;
        for(int i = 2; i < brown/2; i++){
            y = i;
            b = brown/2 - (y-2);
            if((b-2) * (y-2) == yellow){
                answer[0] = b;
                answer[1] = y;
                return answer;
            }
        }
        return answer;
    }
}