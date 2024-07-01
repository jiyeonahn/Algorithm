import java.util.Arrays;
class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] arr = my_string.split("");
        
        String n1 = arr[num1];
        String n2 = arr[num2];
        
        arr[num2] = n1;
        arr[num1] = n2;
        
        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            sb.append(str);
        }
        
        return sb.toString();
    }
}