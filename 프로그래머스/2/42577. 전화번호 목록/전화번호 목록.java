import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String phone_num : phone_book){
            hashMap.put(phone_num, 0);
        }
        
        for(int i = 0; i < phone_book.length; i++){
            String phone_num = phone_book[i];
            for(int j = 1; j < phone_num.length(); j++){
                if(hashMap.get(phone_num.substring(0,j)) == null) continue;
                return false;
                //hashMap.put(phone_num, hashMap.get(phone_num.substring(0,j)) + 1);
            }
        }
        return answer;
    }
}