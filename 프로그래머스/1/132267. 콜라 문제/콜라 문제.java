class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int num = 0;
        while(n > a-1){
            answer += n/a * b;
            n = n/a * b + n%a;
        }
        return answer;
    }
}
