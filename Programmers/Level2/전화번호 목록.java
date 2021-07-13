import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> hash = new HashMap<String, Integer>();

        for(int i = 0; i < phone_book.length; i++)
            hash.put(phone_book[i], i);

        for(int i = 0; i < phone_book.length; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                if(hash.containsKey(phone_book[i].substring(0,j))){
                    answer = false;
                    break;
                }
                answer = true;
            }
            if(answer == false) break;
        }

        return answer;
    }
}