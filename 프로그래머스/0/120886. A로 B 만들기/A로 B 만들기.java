class Solution {
    public int solution(String before, String after) {
        int idx = 0;
        for(int i = 0; i < after.length(); i++){
            idx = before.indexOf(after.substring(i,i+1));
            if(idx == -1){
                return 0;
            }
            before = before.substring(0, idx) + before.substring(idx+1);
        }
        
        return 1;
    }
}