package Level1;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int[] result = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == one[i%5])
                result[0]++;
            if(answers[i] == two[i%8])
                result[1]++;
            if(answers[i] == three[i%10])
                result[2]++;
        }

        int maxNum = result[0];
        for(int i = 1; i < 3; i++) {
            if(result[i] > maxNum)
                maxNum = result[i];
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(result[i] == maxNum){
                list.add(i+1);
            }
        }

        int[] resultArr = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            resultArr[i] = list.get(i);

        return resultArr;
    }
}
