class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        n -= lost.length;
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    n++;
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    reserve[j] = -1;
                    n++;
                    break;
                }
            }
        }
        return n;
    }
}