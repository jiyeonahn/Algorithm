class Solution {
    public int solution(int n) {
        int result = 0;
        int[] numList = new int[n+1];
        for(int i = 1; i <= n; i++){
            numList[i] = i;
        }
        for(int i = 2; i <= n; i ++){
            if(numList[i] == 0) continue;
            for(int j = i * 2; j <= n; j += i){
                numList[j] = 0;
            }
            result++;
        }
        return result;
    }
}