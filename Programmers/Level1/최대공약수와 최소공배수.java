class Solution {
    public int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b % a, a);
    }

    public int[] solution(int n, int m) {
        int[] result = new int[2];
        result[0] = gcd(n, m);
        result[1] = (n * m) / gcd(n, m);

        return result;
    }
}