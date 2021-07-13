class Solution {
    public int fibo(int n){
        int result = 0;
        if(n <= 1) return n;
        int first = 1;
        int second = 1;
        for(int i = 3; i <= n; i++){
            result = first + second;
            first = second % 1234567;
            second = result % 1234567;
        }
        return result;
    }
    public int solution(int n) {
        return fibo(n) % 1234567;
    }
}