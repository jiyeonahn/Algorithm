import java.util.*;
class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        Arrays.sort(mats);
        
        for(int k = mats.length-1; k >= 0; k--){
            int len = mats[k];
            for(int i = 0; i <= park.length - len; i++){
                for(int j = 0; j <= park[0].length - len; j++){
                    boolean isPossible = true;
                    for(int p = i; p < i+len; p++){
                        for(int q = j; q < j+len; q++){
                            if(!"-1".equals(park[p][q])) {
                                isPossible = false;
                                break;
                            }
                        }
                        if(!isPossible) break;
                    }
                    if(isPossible) return len;
                }
            }
        }
        
        return -1;
    }
}