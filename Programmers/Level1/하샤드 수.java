class Solution {
    public boolean solution(int x) {
        String numString = String.valueOf(x);
        int sum = 0;
        int temp = x;
        for(int i = 0; i < numString.length(); i++){
            sum += x % 10;
            x /= 10;
        }
        return temp % sum == 0;


    }
}