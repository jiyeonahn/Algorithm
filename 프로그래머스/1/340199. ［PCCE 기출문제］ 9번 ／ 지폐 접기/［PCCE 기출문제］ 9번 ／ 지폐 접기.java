class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int wMin = Math.min(wallet[0], wallet[1]);
        int bMin = Math.min(bill[0], bill[1]);
        int wMax = Math.max(wallet[0], wallet[1]);
        int bMax = Math.max(bill[0], bill[1]);
        
        while(wMin < bMin || wMax < bMax){
            int max = bMax;
            bMax = Math.max(max/2, bMin);
            bMin = Math.min(max/2, bMin);
            answer++;
        }
        
        return answer;
    }
}