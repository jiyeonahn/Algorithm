class Solution {

    public int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b % a, a);
    }

    public int solution(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            arr[i] = (arr[i-1] * arr[i]) / gcd(arr[i - 1], arr[i]);
        }

        return arr[arr.length - 1];
    }
}