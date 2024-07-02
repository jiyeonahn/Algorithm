class Solution {
    public int solution(int num, int k) {
        String str = num + "";
        for(int i = 1; i <= str.length(); i++){
            if(Integer.parseInt(str.substring(i-1,i)) == k){
                return i;
            }
        }
        return -1;
    }
}