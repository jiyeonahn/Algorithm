import java.time.*;
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        boolean[] isInvalid = new boolean[privacies.length];
        String[] todayArr = today.split("\\.");
        int todayYear = Integer.parseInt(todayArr[0]);
        int todayMonth = Integer.parseInt(todayArr[1]);
        int todayDay = Integer.parseInt(todayArr[2]);
        
        LocalDate date1 = LocalDate.of(todayYear, todayMonth, todayDay);
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < terms.length; i++){
            StringTokenizer st = new StringTokenizer(terms[i]);
            
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++){
            StringTokenizer st = new StringTokenizer(privacies[i]);
            
            String date = st.nextToken();
            
            String type = st.nextToken();
            
            int term = map.get(type);
            
            String[] dateArr = date.split("\\.");
           
            int year = Integer.parseInt(dateArr[0]);
            int month = Integer.parseInt(dateArr[1]);
            int day = Integer.parseInt(dateArr[2]);
            
            LocalDate date2 = LocalDate.of(year, month, day);
            
            LocalDate validDate = date2.plusMonths(term);
           
            if(date1.compareTo(validDate) >= 0){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}