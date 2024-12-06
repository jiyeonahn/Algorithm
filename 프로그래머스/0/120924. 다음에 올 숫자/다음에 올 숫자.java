class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int idx = common.length - 1;
        int diff = common[1] - common[0];
        int diff2 = 0;
        if(common[0] != 0){
            diff2 = common[1] / common[0];
        }
        if(common[2] == common[1] + diff){
            return common[idx] + diff;
        }else{
            return common[idx] * diff2;
        }
    }
}