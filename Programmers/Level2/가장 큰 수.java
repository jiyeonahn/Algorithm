import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] numString = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++)
            numString[i] = String.valueOf(numbers[i]);

        Arrays.sort(numString, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
                // 오름차순 : (a+b).compareTo(b+a)
            }
        });
        if(numString[0].equals("0")) return numString[0];
        StringBuffer sb = new StringBuffer();
        for(String str : numString)
            sb.append(str);

        return sb.toString();
    }
}