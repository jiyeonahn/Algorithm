import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> sum = new TreeSet<>();  
        
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                sum.add(numbers[i] + numbers[j]);
            }
        }
        
        Integer[] arr = sum.toArray(new Integer[0]);
        int answer[] = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
       
        return answer;
    }
}