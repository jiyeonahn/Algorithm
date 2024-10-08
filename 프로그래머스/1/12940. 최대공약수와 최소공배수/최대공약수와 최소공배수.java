class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n,m);
        answer[1] = n*m / answer[0];
        return answer;
    }
    public static int gcd(int a, int b){
        while(b > 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}