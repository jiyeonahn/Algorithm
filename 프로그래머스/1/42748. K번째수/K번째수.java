import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int startIndex = commands[i][0]-1;
            int endIndex = commands[i][1]-1;
            int[] splitArray = new int[endIndex - startIndex + 1];
            int index = 0;
            for(int j = startIndex; j <= endIndex; j++){
                splitArray[index++] = array[j];
            }
            Arrays.sort(splitArray);
            answer[i] = splitArray[commands[i][2]-1];
        }
        return answer;
    }
}