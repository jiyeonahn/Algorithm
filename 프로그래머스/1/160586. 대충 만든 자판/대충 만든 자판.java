class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++){
            int cnt = 0;
            for(int j = 0; j < targets[i].length(); j++){
                char target = targets[i].charAt(j);
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < keymap.length; k++){
                    if(keymap[k].indexOf(target) == -1) continue;
                    min = Math.min(min, keymap[k].indexOf(target)+1);
                }
                if(min == Integer.MAX_VALUE) {
                    cnt = -1;
                    break;
                };
                cnt+=min;
            }
            
            answer[i] = cnt;
        }
        return answer;
    }
}