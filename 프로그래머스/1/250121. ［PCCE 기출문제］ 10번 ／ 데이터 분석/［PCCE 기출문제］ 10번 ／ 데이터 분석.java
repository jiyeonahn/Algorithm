import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        boolean[] isValid = new boolean[data.length];

        HashMap<String, Integer> map = new HashMap<>();

        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        int cnt = 0;

        for(int i = 0; i < data.length; i++){
            int idx = map.get(ext);
            if(data[i][idx] <= val_ext){
                isValid[i] = true;
                cnt++;
            }
        }

        int[][] answer = new int[cnt][4];
        int idx = 0;

        for(int i = 0; i < data.length; i++){
            if(isValid[i]){
                answer[idx][0] = data[i][0];
                answer[idx][1] = data[i][1];
                answer[idx][2] = data[i][2];
                answer[idx][3] = data[i][3];
                idx++;
            }
        }
        
        int finalIdx = map.get(sort_by);
        Arrays.sort(answer, (a, b) -> Integer.compare(a[finalIdx],b[finalIdx]));

        return answer;
    }
}