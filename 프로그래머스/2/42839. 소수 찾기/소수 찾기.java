import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> uniqueNumbers = new HashSet<>();
        dfs("", numbers, uniqueNumbers);
        
        for(int num : uniqueNumbers){
            if(isPrime(num)){
                answer++;
            };
        }
        return answer;
    }
    
    void dfs(String current, String remaining, Set<Integer> uniqueNumbers){
        if(!current.equals("")){
            uniqueNumbers.add(Integer.parseInt(current));
        }
        for(int i = 0; i < remaining.length(); i++){
            dfs(current + remaining.charAt(i), remaining.substring(0,i) + remaining.substring(i+1), uniqueNumbers);
        }
    }
    
    public boolean isPrime(int n){
        if(n < 2) return false;
        int count = 0;
        for(int i = 2; i <= n/2; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}