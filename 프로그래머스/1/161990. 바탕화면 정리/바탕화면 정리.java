import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        //왼쪽 위랑 오른쪽 아래쪽을 찾자
        int minX = 51;
        int minY = 51;
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[0].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        int[] answer = {minX, minY, maxX+1, maxY+1};

        return answer;
    }
}