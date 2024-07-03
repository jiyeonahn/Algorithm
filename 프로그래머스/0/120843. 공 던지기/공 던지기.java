class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        answer = (2*(k-1)+1) % numbers.length;
        return answer == 0 ? numbers.length : answer;
    }
}