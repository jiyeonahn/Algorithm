import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        HashMap<Integer, int[]> map = new HashMap<>();
        
        map.put(1, new int[]{0,0});
        map.put(2, new int[]{0,1});
        map.put(3, new int[]{0,2});
        
        map.put(4, new int[]{1,0});
        map.put(5, new int[]{1,1});
        map.put(6, new int[]{1,2});
        
        map.put(7, new int[]{2,0});
        map.put(8, new int[]{2,1});
        map.put(9, new int[]{2,2});
        
        map.put(0, new int[]{3,1});
        
        int[] lefthand = new int[]{3,0};
        int[] righthand = new int[]{3,2};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numbers.length; i++){
            
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                lefthand = map.get(numbers[i]);
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                righthand = map.get(numbers[i]);
            }
            else{
                int[] location = map.get(numbers[i]);
                int leftLen = Math.abs(location[0] - lefthand[0]) + Math.abs(location[1] - lefthand[1]);
                int rightLen = Math.abs(location[0] - righthand[0]) + Math.abs(location[1] - righthand[1]);
                if(leftLen < rightLen){
                    sb.append("L");
                    lefthand = map.get(numbers[i]);
                }else if(leftLen > rightLen){
                    sb.append("R");
                    righthand = map.get(numbers[i]);
                }else{
                    if(hand.equals("right")){
                        sb.append("R");
                        righthand = map.get(numbers[i]);
                    }else{
                        sb.append("L");
                        lefthand = map.get(numbers[i]);
                    }
                }
            }          
        }
        
        return sb.toString();
    }
}