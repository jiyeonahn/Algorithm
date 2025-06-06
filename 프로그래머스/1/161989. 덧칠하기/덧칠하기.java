class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] wall = new int[n];
        
        for(int i = 0; i < section.length; i++){
            wall[section[i]-1] = -1;
        }
    
        for(int i = 0 ; i < n; i++){
            if(wall[i] == -1){
                answer++;
                for(int j = 0; j < m; j++){
                    if(i+j < n){
                        wall[i+j] = 0;
                    }
                }
            }
        }
        
        return answer;
    }
}