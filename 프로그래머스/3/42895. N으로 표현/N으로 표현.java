class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        recursive(N, 0, 0, number);
        return answer > 8 ? -1 : answer;
    }
    public void recursive(int N, int count, int current, int target){
        if(current == target){
            answer = Math.min(count, answer);
            return;
        }
        
        if(count >= 8){
            return;
        }
        
        int newN = 0;
        for(int i = 0; i < 8- count; i++){
            newN = newN * 10 + N;
            recursive(N, count + i + 1, current + newN, target);
            recursive(N, count + i + 1, current - newN, target);
            recursive(N, count + i + 1, current * newN, target);
            recursive(N, count + i + 1, current / newN, target);
        }
    }
}